package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOProductos;

public interface ProductoService {

	public List<DTOProductos> listarProductos();
	public void insertarProducto(DTOProductos productos);
	public void eliminarProducto(int id);
	public DTOProductos encontrarProductoPorId(int id);
	public void ActualizarProducto(int id, DTOProductos producto);

}
