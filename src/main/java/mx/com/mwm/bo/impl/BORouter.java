package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Router;
import mx.com.mwm.bo.BORouterInterface;
import mx.com.mwm.dto.DTORouter;

@Component("boRouter")
@Scope("prototype")
public class BORouter implements BORouterInterface {

	@Override
	public DTORouter modelRouterToDtoRouter(Router modelRouter) {
		DTORouter dtoRouter=new DTORouter();
		dtoRouter.setIdRouter(modelRouter.getId());
		dtoRouter.setNombreRouter(modelRouter.getNombre());
		dtoRouter.setIpODnsRouter(modelRouter.getIpDns());
		dtoRouter.setUserRouter(modelRouter.getNombreUser());
		dtoRouter.setPassRouter(modelRouter.getLlave());
		dtoRouter.setUbicacionRouter(modelRouter.getUbicacion());
		return dtoRouter;
	}

	@Override
	public List<DTORouter> listModelRouterToListDtoRouter(List<Router> listModelRouter) {
		List<DTORouter> listDtoRouter=null;
		if(listModelRouter!=null) {
			listDtoRouter=new ArrayList<DTORouter>();
			for(Router modelRouter: listModelRouter) {
				listDtoRouter.add(this.modelRouterToDtoRouter(modelRouter));
			}
		}
		return listDtoRouter;
	}

	@Override
	public Router DtoRouterToModelRouter(DTORouter dtoRouter) {
		Router modelRouter= new Router();
		modelRouter.setId(dtoRouter.getIdRouter());
		modelRouter.setNombre(dtoRouter.getNombreRouter());
		modelRouter.setIpDns(dtoRouter.getIpODnsRouter());
		modelRouter.setNombreUser(dtoRouter.getUserRouter());
		modelRouter.setLlave(dtoRouter.getPassRouter());
		modelRouter.setUbicacion(dtoRouter.getUbicacionRouter());
		return modelRouter;
	}

	@Override
	public List<Router> listDtoRouterTolistModelRouter(List<DTORouter> listDtoRouter) {
		List<Router> listModelRouter =null;
		if(listDtoRouter!=null) {
			listModelRouter=new ArrayList<Router>();
			for(DTORouter dtoRouter:listDtoRouter) {
				listModelRouter.add(this.DtoRouterToModelRouter(dtoRouter));
			}
		}
		return listModelRouter;
	}

}
