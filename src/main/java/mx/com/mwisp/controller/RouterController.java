package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.model.Router;
import mx.com.mwisp.service.RouterService;
import mx.com.mwm.dto.DTORouter;
import mx.com.mwm.dto.helper.FormRouter;

@Controller
@ManagedBean
@RequestScoped
public class RouterController{

	private String opcionActual;
	/**
	 * 
	 */
	@Autowired
	RouterService routerService;

	FormRouter formRouter;
	
	public RouterController() {
		try{
			formRouter=new FormRouter();
		}catch(Exception e) {
			System.out.println(":::Ocurrió un error!!!");
		}
	}
	
	public String getOpcionActual() {
		return opcionActual;
	}

	public void setOpcionActual(String opcionActual) {
		this.opcionActual = opcionActual;
	}
	public List<DTORouter> routerList(){
		formRouter.setListRouter(routerService.routerList());
		//formRouter.setListRouter(routerService.routerList());
		return formRouter.getListRouter();
	}
	/*public void guardarRouter(Router router) {
		System.out.println("Guardando..");
		routerService.guardar(router);
	}*/
	public String guardarRouter() {
		routerService.agregarRouter(new DTORouter(formRouter.getNombre(),formRouter.getIpDns(), formRouter.getNombreUsuario(), formRouter.getObtenerLlave(), formRouter.getUbicacion()));
		//routerService.agregarRouter(new Router(router.getNombre(),router.getIpDns(),router.getNombreUsuario(),router.getLlave(),router.getUbicacion()));
		return "ListaRouter.xhtml?faces-redirect=true";
	}
	
	public void eliminarRouter(int id) {
		routerService.eliminarRouter(id);
	}

	public FormRouter getFormRouter() {
		return formRouter;
	}

	public void setFormRouter(FormRouter formRouter) {
		this.formRouter = formRouter;
	}
	
	public String editarRouter(){
		formRouter.setObtenerId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRouterId"));
		int id=Integer.parseInt(formRouter.getObtenerId());
		DTORouter dtoRouter=new DTORouter();
		dtoRouter=routerService.buscarRouterPorId(id);
		formRouter.setNombre(dtoRouter.getNombreRouter());
		formRouter.setIpDns(dtoRouter.getIpODnsRouter());
		formRouter.setNombreUsuario(dtoRouter.getUserRouter());
		formRouter.setObtenerLlave(dtoRouter.getPassRouter());
		formRouter.setUbicacion(dtoRouter.getUbicacionRouter());
		return "EditarRouter";
	}
	
	public String actualizarRouter() {
		int id=Integer.parseInt(formRouter.getObtenerId());
		routerService.actualizarRouter(id, new DTORouter(formRouter.getNombre(), formRouter.getIpDns(), formRouter.getNombreUsuario(), formRouter.getObtenerLlave(), formRouter.getUbicacion()));
		return "ListaRouter.xhtml?faces-redirect=true";
	}
}
