package mx.com.mwisp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.controller.ClientesController;

public class Main {

	public static void main(String[] args) {
		
		ApiConnection con;
		try {
			con=ApiConnection.connect("10.1.3.1");
			con.login("admin", "");
			List<Map<String, String>> rs = con.execute("/ip/firewall/address-list/print where comment!=null");
			System.out.println(rs.get(rs.size()-1));
			Map<String, String> map=rs.get(rs.size()-1);
			System.out.println("id"+map.get(".id")+" Nombre: "+map.get("comment"));
		}catch(MikrotikApiException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<ClientesController> listaClientes() {
		//FormRouter tamano = new FormRouter();
		ApiConnection con;
		
		//for (int i = 0; i <= tamano.getListRouter().size(); i++) {
			List<Map<String, String>> rs;
			try {
				// con=ApiConnection.connect("mercadowispmexico.dyndns.org"); //ROUTER MIGUEL
				// for (int i = 0; i <= routerDaoImpl.routerList().size(); i++) {
				con = ApiConnection.connect("10.1.3.1");
				con.login("admin", "");
				// con.login("sistema","isc2017");// ROUTER MIGUEL
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
				return listClientes;

			} catch (MikrotikApiException e) {
				e.printStackTrace();

				return null;
			}
		}
}
