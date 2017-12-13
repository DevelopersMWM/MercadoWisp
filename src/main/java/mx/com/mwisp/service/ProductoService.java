package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwisp.model.Productos;


public interface ProductoService {

	public List<Productos> listarProductos();
	public void insertarProducto(Productos productos);
	public void eliminarProducto(int id);
	public Productos encontrarProductoPorId(int id);

}
