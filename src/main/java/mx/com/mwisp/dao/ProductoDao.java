package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Productos;

public interface ProductoDao {
	public List<Productos> listaProductos();

	public void insertarProducto(Productos productos);

	public void eliminarProducto(int id);
	
	public Productos encontrarProductoPorId(int id);
	
	public void ActualizarProducto(int id, Productos producto);

	
}
