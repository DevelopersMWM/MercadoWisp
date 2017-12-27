package mx.com.mwisp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.controller.PlanController;
import mx.com.mwisp.service.PlanService;
import mx.com.mwisp.util.Translator;

@Service
public class PlanServiceImpl implements PlanService {

	@Override
	public List<PlanController> listaPlan() {
		ApiConnection con;
		List<Map<String, String>> rs;
		try {
			//con=ApiConnection.connect("mercadowispmexico.dyndns.org");
			con=ApiConnection.connect("10.1.1.1");
			//con.login("sistema", "isc2017");
			con.login("admin","");
			rs = con.execute("/ip/firewall/mangle/print where action=mark-connection");
			List<PlanController> listPlanController = new ArrayList<PlanController>();
			for (Map<String,String> map : rs) {
				PlanController planController=new PlanController();
				planController.setId(map.get(".id") != null ? map.get(".id") : null);
				planController.setNombre(map.get("comment") != null ? map.get("comment") : null);
				listPlanController.add(planController);
			}
			con.close();
			return listPlanController;
			/*rs = con.execute("/queue/type/print where pcq-src-address6-mask=64");
			for (Map<String,String> map : rs) {
				PlanController planController=new PlanController();
				planController.setBajada(map.get("name"));
			}*/
		} catch (MikrotikApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void crearPlan(PlanController plan) {
		String script = "/ip/firewall/mangle/add action=mark-connection chain=prerouting comment=%s new-connection-mark=%s_conn passthrough=yes src-address-list=%s";
		String script2 = "/ip/firewall/mangle/add action=mark-packet chain=prerouting connection-mark=%s_conn new-packet-mark=%s_pack passthrough=no";
		String resultado=String.format(script, plan.getNombre(),plan.getNombre(),plan.getNombre());
		String Resultado2=String.format(script2, plan.getNombre(),plan.getNombre());
		String word,en;
		Translator http= new Translator();
		ApiConnection conCP;
		try {
			conCP=ApiConnection.connect("");
			conCP.login("", "");
			conCP.execute(resultado);
			conCP.execute(Resultado2);
			System.out.println("Plan agregado Correctamente");
		}catch(MikrotikApiException e) {
			en=e.getMessage();
			try {
				word=http.callUrlAndParseResult("en","es",en);
				System.out.println("Plan no agregador por: "+word);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void eliminarPlan(String idPlan) {
		ApiConnection conDel;
		Translator http=new Translator();
		String word,en,sctript="/ip/firewall/mangle/remove .id=%s";
		String resultado=String.format(sctript, idPlan);
		try {
			conDel=ApiConnection.connect("");
			conDel.login("", "");
			conDel.execute(resultado);
		}catch(MikrotikApiException e) {
			en=e.getMessage();
			try {
				word=http.callUrlAndParseResult("en", "es", en);
				System.out.println("Plan no elimicado por: "+ word);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
