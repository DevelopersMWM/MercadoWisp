package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.RouterDao;
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
		routerDaoImpl.eliminarRouterEnDB(id);
		
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
