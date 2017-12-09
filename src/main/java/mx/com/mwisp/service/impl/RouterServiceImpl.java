package mx.com.mwisp.service.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.RouterDao;
import mx.com.mwisp.model.Router;
import mx.com.mwisp.service.RouterService;

@Service
public class RouterServiceImpl implements RouterService {
	@Autowired
	RouterDao routerDaoImpl;

	@Transactional
	@Override
	public List<Router> routerList() {
		// TODO Auto-generated method stub
		return routerDaoImpl.routerList();
	}

	
	@Override
	public Router guardar(Router router) {
		// TODO Auto-generated method stub
		routerDaoImpl.guardarRouterEnDB(router);
		return guardar(router); 
	}

}
