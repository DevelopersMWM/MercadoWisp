package mx.com.mwisp.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.dao.RouterDao;
import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Router;
import mx.com.mwisp.service.RouterService;
import mx.com.mwm.bo.BORouterInterface;
import mx.com.mwm.dto.DTORouter;

@Service
public class RouterServiceImpl implements RouterService {
	@Autowired
	RouterDao routerDaoImpl;
	
	@Autowired
	BORouterInterface boRouterImpl;
	
	@Autowired
	ClienteInternetDAO clienteInternet;
	
	@Transactional
	@Override
	public List<DTORouter> routerList() {
		return boRouterImpl.listModelRouterToListDtoRouter(routerDaoImpl.routerList());
	}
	
	@Transactional
	@Override
	public void agregarRouter(DTORouter dtoRouter) {
		Router modelRouter= boRouterImpl.DtoRouterToModelRouter(dtoRouter);
		routerDaoImpl.guardarRouterEnDB(modelRouter);
	}

	@Transactional
	@Override
	public void eliminarRouter(int id) {
		FacesMessage mensaje=null;
		if(this.encontrarRouterEnCliente(id)==true) {
			mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualmente tiene Clientes y Planes asignados a este router", null);
			System.out.println("Actualmente tiene Clientes y Planes asignados a este router");
		}else {
			routerDaoImpl.eliminarRouterEnDB(id);
			mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO, "Router eliminado Correctamente", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	public boolean encontrarRouterEnCliente(int idRouter) {
		for(ClienteInternet cliente:clienteInternet.listaClientes()) {
			if(cliente.getRouter().getId()==idRouter) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public void actualizarRouter(int id, DTORouter DtoRouter) {
		Router modelRouter=boRouterImpl.DtoRouterToModelRouter(DtoRouter);
		routerDaoImpl.actulizarRouterEnDB(id, modelRouter);
	}

	@Transactional
	@Override
	public DTORouter buscarRouterPorId(int id) {
		return boRouterImpl.modelRouterToDtoRouter(routerDaoImpl.findById(id));
	}

}
