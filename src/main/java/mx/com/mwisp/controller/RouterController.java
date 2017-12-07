package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.model.Router;
import mx.com.mwisp.service.RouterService;

@Controller
@ManagedBean
@RequestScoped
public class RouterController {
	
	@Autowired
	RouterService routerService;
	
	private String nombre;
	private String ipDns;
	private String nombreUsuario;
	private String llave;
	private String ubicacion;
	
	//private List<Router> routerList;
	
	public RouterController() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIpDns() {
		return ipDns;
	}

	public void setIpDns(String ipDns) {
		this.ipDns = ipDns;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public List<Router> routerList(){
		return routerService.routerList();
	}
	/*public List<Router> getRouterList() {
		return routerList;
	}

	public void setRouterList(List<Router> routerList) {
		this.routerList = routerList;
	} 
	
	public List<Router> getRouterDetails() {
		System.out.println("Lamando getRouterDetails para mostrar routers... ");
		RouterDAOImpl dbObj=new RouterDAOImpl();
		routerList=dbObj.getRouter();
		for(Router selectedRouter : routerList) {
			//selectedRouter.getId();
			nombre=selectedRouter.getNombre();
			ipDns=selectedRouter.getIpDns();
			nombreUsuario=selectedRouter.getNombreUser();
			System.out.println("Nombre: " + nombre + " ipDns: " + ipDns + " Nombre de Usuario: " + nombreUsuario);
			//selectedRouter.getLlave();
			//lectedRouter.getUbicacion();
			//System.out.println("id: " + id +" nombre: "+nombre+" IpDNS: "+ipDns+" nombre Usurario: " +nombreUser+" llave: " + llave + " Ubicacion: " + ubicacion + " ");
		}
		return routerList;
	}*/
}
