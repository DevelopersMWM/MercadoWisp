package mx.com.mwisp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.com.mwisp.model.Router;
import mx.com.mwm.dto.DTORouter;

public interface RouterDao{
	public List<Router> routerList();
	public void guardarRouterEnDB(Router router);
	public Router findById(int id);
	public void eliminarRouterEnDB(int id);
	public void actulizarRouterEnDB(int id,Router router);
}
