package mx.com.mwisp.service.impl;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.dao.PlanDAO;
import mx.com.mwisp.dao.RouterDao;
import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Planes;
import mx.com.mwisp.model.Router;
import mx.com.mwisp.service.PlanesService;
import mx.com.mwm.bo.BOPlanesInterface;
import mx.com.mwm.dto.DTOPlan;
import mx.com.mwisp.util.Translator;

@Service
public class PlanesServiceImpl implements PlanesService {

	@Autowired
	PlanDAO planDaoImpl;
	@Autowired
	BOPlanesInterface BoPlanImpl;
	@Autowired
	RouterDao routerDoImpl;
	@Autowired
	ClienteInternetDAO clientePlan;

	@SuppressWarnings("static-access")
	@Transactional
	@Override
	public void agregarPlan(DTOPlan dtoPlan) {
		Planes modelPlan = BoPlanImpl.DtoPlanToModelPlan(dtoPlan);
		String scriptMangleConection = "/ip/firewall/mangle/add action=mark-connection chain=prerouting comment=%s new-connection-mark=%s_conn passthrough=yes src-address-list=%s";
		String scriptManglePack = "/ip/firewall/mangle/add action=mark-packet chain=prerouting connection-mark=%s_conn new-packet-mark=%s_pack passthrough=no";
		String scriptSubida = "/queue/type/add kind=pcq name=%sBPS-UP pcq-classifier=dst-address pcq-dst-address6-mask=64 pcq-rate=%s pcq-src-address6-mask=64";
		String scriptBajada = "/queue/type/add kind=pcq name=%sBPS-DW pcq-classifier=dst-address pcq-dst-address6-mask=64 pcq-rate=%s pcq-src-address6-mask=64";

		String subida = "%sBPS-UP";
		String bajada = "%sBPS-DW";

		String scriptQueueTreeSubida = "/queue/tree/add name=\"SUBIDA %s\" packet-mark=%s_pack parent=\"SUBIDA TOTAL\" queue=%s";
		String scriptQueueTreeBajada = "/queue/tree/add name=\"DESCARGA %s\" packet-mark=%s_pack parent=\"DESCARGA TOTAL\" queue=%s";

		String manglePlanCon = String.format(scriptMangleConection, modelPlan.getNombre(), modelPlan.getNombre(),
				modelPlan.getNombre());
		String manglePlanPack = String.format(scriptManglePack, modelPlan.getNombre(), modelPlan.getNombre());
		String queueTypeUp = String.format(scriptSubida, modelPlan.getSubida(), modelPlan.getBajada());
		String queueTypeDw = String.format(scriptBajada, modelPlan.getBajada(), modelPlan.getBajada());
		String subidaFormat = String.format(subida, modelPlan.getSubida());
		String bajadaFormat = String.format(bajada, modelPlan.getBajada());
		String queueTreesubida = String.format(scriptQueueTreeSubida, modelPlan.getNombre(), modelPlan.getNombre(),
				subidaFormat);
		String queueTreeBajada = String.format(scriptQueueTreeBajada, modelPlan.getNombre(), modelPlan.getNombre(),
				bajadaFormat);

		Translator http = new Translator();
		String word, en;

		System.out.println("==> " + manglePlanCon);
		System.out.println("==> " + manglePlanPack);
		System.out.println("==> " + queueTypeUp);
		System.out.println("==> " + queueTypeDw);
		System.out.println("==> " + queueTreesubida);
		System.out.println("==> " + queueTreeBajada);

		ApiConnection conCP;
		try {
			for (Router modelRouter : routerDoImpl.routerList()) {

				conCP = ApiConnection.connect(modelRouter.getIpDns());
				conCP.login(modelRouter.getNombreUser(), modelRouter.getLlave());
				conCP.execute(manglePlanCon);
				conCP.execute(manglePlanPack);
				if (this.encontrarQueueType(modelRouter.getIpDns(), modelRouter.getNombreUser(), modelRouter.getLlave(),
						subidaFormat) == false) {
					conCP.execute(queueTypeUp);
				}
				if (this.encontrarQueueType(modelRouter.getIpDns(), modelRouter.getNombreUser(), modelRouter.getLlave(),
						bajadaFormat) == false) {
					conCP.execute(queueTypeDw);
				}
				conCP.execute(queueTreeBajada);
				conCP.execute(queueTreesubida);
				System.out.println("Plan agregado");
			}
			planDaoImpl.insertarPlanEnDB(modelPlan);
		} catch (MikrotikApiException e) {
			en = e.getMessage();
			System.out.println("Error==>>" + en);
			// try {
			// word = http.callUrlAndParseResult("en", "es", en);
			// System.out.println("Ocurrió un: " + word);
			// } catch (Exception e1) {
			// e1.printStackTrace();
			// }
		}
	}

	public boolean encontrarQueueType(String host, String userName, String pass, String plan) {
		ApiConnection con;
		List<Map<String, String>> rs;
		try {
			con = ApiConnection.connect(host);
			con.login(userName, pass);
			rs = con.execute("/queue/type/print where kind=pcq");
			for (Map<String, String> Plan : rs) {
				if (Plan.get("name").equals(plan)) {
					return true;
				}
			}
			return false;
		} catch (MikrotikApiException e) {
			System.out.println("Error" + e.getMessage());
		}
		return false;
	}

	@Transactional
	@Override
	public List<DTOPlan> listarPlanes() {
		return BoPlanImpl.listModelPlanToListDtoPlan(planDaoImpl.listaPlanes());
	}

	@Transactional
	@Override
	public void eliminarPlan(int id) {
		FacesMessage mensaje=null;
		if(this.encontrarPlanEnCliente(id)==true) {
			mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualmente tiene clientes asignados a este plan", null);
			System.out.println("\n Actualmente tiene clientes asignados a este plan");
		}else {
		planDaoImpl.eliminarPlanEnDB(id);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	public boolean encontrarPlanEnCliente(int idPlan) {
		//List<ClienteInternet> listaClientes=null;
		// = new ClienteInternet();
		for (ClienteInternet clienteInternet : clientePlan.listaClientes()) {
			if(clienteInternet.getPlan().getIdPlan()==idPlan) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public void actualizarPlan(int id, DTOPlan dtoPlan) {
		Planes modelPlan = BoPlanImpl.DtoPlanToModelPlan(dtoPlan);
		planDaoImpl.actualizarPlanEnDB(id, modelPlan);

	}

	@Transactional
	@Override
	public DTOPlan findPlanConId(int id) {
		return BoPlanImpl.modelPlanToDtoPlan(planDaoImpl.findPlanPorId(id));
	}

}
