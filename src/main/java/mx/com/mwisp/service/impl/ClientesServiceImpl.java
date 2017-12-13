package mx.com.mwisp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.controller.ClientesController;
import mx.com.mwisp.service.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Override
	public List<ClientesController> listaClientes() {
		ApiConnection con;
		List<Map<String, String>> rs;
		try {
//			con=ApiConnection.connect("mercadowispmexico.dyndns.org");
			con=ApiConnection.connect("mercadowispmexico.dyndns.org");
			con.login("sistema","isc2017");
//			con.login("sistema","isc2017");
//			rs = con.execute("/ip/firewall/address-list/print where list=1-MOROSO");
			rs = con.execute("/ip/firewall/address-list/print where comment!=null");
			List<ClientesController> listClientes= new ArrayList<ClientesController>();
			for (Map<String,String> map : rs) {
				ClientesController clientes= new ClientesController();
				clientes.setId(map.get(".id")!= null ? map.get(".id") : null);
				clientes.setNombre(map.get("comment") != null ? map.get("comment") : null);
				clientes.setIp(map.get("address") != null ? map.get("address") : null);
				clientes.setFecha(map.get("creation-time") != null ? map.get("creation-time") : null);
				clientes.setPlan(map.get("list") != null ? map.get("list") : null);
				listClientes.add(clientes);
			}
			con.close();
			return listClientes;
		}catch(MikrotikApiException e) {
			e.printStackTrace();
			
			return null;
		}
	}

}
