package mx.com.mwisp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.com.mwisp.model.Router;

public interface RouterDao{
	public List<Router> routerList();
	public void guardarRouterEnDB(Router router);
	public Router findByNombre(String nombre);
	public void eliminarRouterEnDB(int id);
}
