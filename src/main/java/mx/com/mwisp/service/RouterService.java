package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwisp.model.Router;

public interface RouterService {
	public void agregarRouter(Router router);
	public List<Router> routerList();
}
