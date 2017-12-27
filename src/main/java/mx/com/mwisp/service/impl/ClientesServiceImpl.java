package mx.com.mwisp.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.controller.ClientesController;
import mx.com.mwisp.service.ClientesService;
import mx.com.mwisp.service.RouterService;
import mx.com.mwisp.util.Translator;
import mx.com.mwm.dto.DTORouter;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	RouterService routerServiceImpl;

	@Override
	public List<ClientesController> listaClientes() {
		ApiConnection con;
		List<Map<String, String>> rs;
		try {
			 //con=ApiConnection.connect("mercadowispmexico.dyndns.org"); //ROUTER MIGUEL
//			for (int i = 0; i <= routerDaoImpl.routerList().size(); i++) {
				con = ApiConnection.connect("10.1.3.1");
				con.login("admin","");
				//con.login("sistema","isc2017");// ROUTER MIGUEL
				// rs = con.execute("/ip/firewall/address-list/print where list=1-MOROSO");
				rs = con.execute("/ip/firewall/address-list/print where comment!=null");
				List<ClientesController> listClientes = new ArrayList<ClientesController>();
				for (Map<String, String> map : rs) {
					ClientesController clientes = new ClientesController();
					clientes.setId(map.get(".id") != null ? map.get(".id") : null);
					clientes.setNombre(map.get("comment") != null ? map.get("comment") : null);
					clientes.setIp(map.get("address") != null ? map.get("address") : null);
					clientes.setFecha(map.get("creation-time") != null ? map.get("creation-time") : null);
					clientes.setPlan(map.get("list") != null ? map.get("list") : null);
					listClientes.add(clientes);
				}
				con.close();
			//}
			return listClientes;
			
		} catch (MikrotikApiException e) {
			e.printStackTrace();

			return null;
		}
	}

	public void insertarUsuario(ClientesController cliente) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String nombre = cliente.getNombre();
		String ip = cliente.getIp();
		String plan = cliente.getPlan();
		String sector = cliente.getSector();
		int id=Integer.parseInt(cliente.getOpcionActual());
		DTORouter dtoRouter=new DTORouter();
		dtoRouter=routerServiceImpl.buscarRouterPorId(id);
		String ipRouter=dtoRouter.getIpODnsRouter();
		String Usuario=dtoRouter.getUserRouter();
		String password=dtoRouter.getPassRouter();
		String corte = df.format(cliente.getDiaCorte());
		ApiConnection con;
		Translator http = new Translator();
		String word;
		String en;
		String script = "/ip/firewall/address-list/add address=%s comment=\"%s-%s-%s\" list=%s";
		String resultado = String.format(script, ip, nombre, sector, corte, plan);
		System.out.println("Resultado " + resultado);
		try {
			con = ApiConnection.connect(ipRouter);
			con.login(Usuario,password);
			con.execute(resultado);
			System.out.println("\nCliente Agregado");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("CreadoClienteNombre", nombre);
		} catch (MikrotikApiException e) {
			en = e.getMessage();
			try {
				word = http.callUrlAndParseResult("en", "es", en);
				System.out.println("Algo salio mal... " + word);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("CreadoClienteNombre", word);
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarCliente(String id) {
		ApiConnection con;
		String script="/ip/firewal/address-list/remove .id=%s";
		String resultado=String.format(script, id);
		try {
			con=ApiConnection.connect("10.1.1.1");
			con.login("admin","");
			con.execute(resultado);
			System.out.println("Cliente eliminado");
		}catch(MikrotikApiException e){
			e.getMessage();
		}
	}

	@Override
	public void prueba(ClientesController prueba) {
		int id=Integer.parseInt(prueba.getOpcionActual());
		DTORouter dtoRouter=new DTORouter();
		dtoRouter=routerServiceImpl.buscarRouterPorId(id);
		String ip=dtoRouter.getIpODnsRouter();
		String Usuario=dtoRouter.getUserRouter();
		String password=dtoRouter.getPassRouter();
		System.out.println("Ip: "+ip+" user: "+ Usuario+" contrase�a: "+password);
	}
}
