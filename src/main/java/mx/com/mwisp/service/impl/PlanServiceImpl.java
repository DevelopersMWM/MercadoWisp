package mx.com.mwisp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import mx.com.mwisp.controller.PlanController;
import mx.com.mwisp.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Override
	public List<PlanController> listaPlan() {
		ApiConnection con;
		List<Map<String, String>> rs;
		try {
			//con=ApiConnection.connect("mercadowispmexico.dyndns.org");
			con=ApiConnection.connect("172.18.2.254");
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

}
