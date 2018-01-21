package mx.com.mwisp.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.dao.DireccionDAO;
import mx.com.mwisp.dao.PersonaDAO;
import mx.com.mwisp.dao.PlanDAO;
import mx.com.mwisp.dao.RouterDao;
import mx.com.mwisp.dao.SectorDao;
import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Direccion;
import mx.com.mwisp.model.Persona;
import mx.com.mwisp.model.Planes;
import mx.com.mwisp.model.Router;
import mx.com.mwisp.model.Sector;
import mx.com.mwisp.service.ClienteBdMkService;
import mx.com.mwisp.util.Translator;
import mx.com.mwm.bo.BOClienteInternetInterface;
import mx.com.mwm.bo.BODireccionInterface;
import mx.com.mwm.bo.BOPersonaInterface;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.DTODireccion;
import mx.com.mwm.dto.DTOPersona;

@Service
public class ClienteBdMkserviceImpl implements ClienteBdMkService {
	
	@Autowired
	ClienteInternetDAO clienteServicioDao;
	@Autowired
	DireccionDAO direccionDaoImpl;
	@Autowired
	PersonaDAO personaDaoImpl;
	@Autowired
	RouterDao routerDaoImpl;
	@Autowired
	PlanDAO planDaoImpl;
	@Autowired
	SectorDao sectorDaoImpl;
	
	@Autowired
	BOClienteInternetInterface boClienteServicio;
	@Autowired
	BODireccionInterface boDireccionImpl;
	@Autowired
	BOPersonaInterface boPersonaImpl;

	@SuppressWarnings("static-access")
	@Transactional
	@Override
	public void insertarClienteEnBDYMk(DTOClienteInternet dtoClienteInternet, DTODireccion dtoDireccion,DTOPersona dtoPersona) {
		String nombreCliente= dtoPersona.getNombrePersona();
		String ipCliente=dtoClienteInternet.getIpCliente();
		
		Planes modelPlan=new Planes();
		modelPlan=planDaoImpl.findPlanPorId(dtoClienteInternet.getIdPlan());
		String planCliente=modelPlan.getNombre();
		
		Router modelRouter=new Router();
		modelRouter=routerDaoImpl.findById(dtoClienteInternet.getIdRouter());
		String ipRouter=modelRouter.getIpDns();
		String userRouter=modelRouter.getNombreUser();
		String passRouter=modelRouter.getLlave();
		
		Sector modelSector=new Sector();
		modelSector=sectorDaoImpl.encontrarSectorPorId(dtoClienteInternet.getIdSector());
		String nombreSector=modelSector.getNombreSector();
		
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		String corte=df.format(dtoClienteInternet.getPrimerPago());
				
		
		ApiConnection con;
		Translator http= new Translator();
		String word,en;
		String script = "/ip/firewall/address-list/add address=%s comment=\"%s-%s-%s\" list=%s";
		String resultado=String.format(script, ipCliente,nombreCliente,nombreSector,corte,planCliente);
		try {
			con=ApiConnection.connect(ipRouter);
			con.login(userRouter, passRouter);
			con.execute(resultado);
			List<Map<String, String>> rs = con.execute("/ip/firewall/address-list/print where comment!=null");
			System.out.println(rs.get(rs.size()-1));
			Map<String, String> map=rs.get(rs.size()-1);
			dtoClienteInternet.setIdMk(map.get(".id"));
			System.out.println("id"+map.get(".id")+" Nombre: "+map.get("comment"));
			System.out.println("cliente agregado al mk");
			Persona modelPersona=boPersonaImpl.dtoPersonaToModelPersona(dtoPersona);
			personaDaoImpl.insertarPersonaEnDB(modelPersona);
			List<Persona> listarPersona=personaDaoImpl.personList();
			Persona personAgregada=listarPersona.get(listarPersona.size()-1);
			int idPersonaNueva=personAgregada.getId_Persona();
			dtoDireccion.setIdPersona(idPersonaNueva);
			dtoClienteInternet.setIdPersona(idPersonaNueva);
			Direccion modelDireccion=boDireccionImpl.dtoDireccionToModelDireccion(dtoDireccion);
			direccionDaoImpl.insertarDireccionEnDB(modelDireccion);
			ClienteInternet modelClienteInternet=boClienteServicio.dtoClienteToModelCliente(dtoClienteInternet);
			clienteServicioDao.guardarClienteEnDB(modelClienteInternet);
			System.out.println("todo Salió bien!!");
			
		}catch (MikrotikApiException e) {
			en=e.getMessage();
			try {
				word=http.callUrlAndParseResult("en", "es", en);
				System.out.println("Algo slio mal :( "+ word);
			}catch (Exception e1) {
				e1.printStackTrace();
				// TODO: handle exception
			}
			// TODO: handle exception
		}
	}

}
