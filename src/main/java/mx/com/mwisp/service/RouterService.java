package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTORouter;

public interface RouterService {
	
	public void agregarRouter(DTORouter router);
	public List<DTORouter> routerList();
	public void eliminarRouter(int id);
	public void actualizarRouter(int id,DTORouter router);
	public DTORouter buscarRouterPorId(int id);
}
