package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Router;

public interface RouterDao {
	public List<Router> routerList();
	public void guardarRouterEnDB(Router router);
}
