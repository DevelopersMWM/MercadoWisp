package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ProductoDao;
import mx.com.mwisp.model.Productos;
import mx.com.mwisp.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired 
	ProductoDao productoDaoImpl;
	

	


	@Transactional(readOnly=true, rollbackFor={Exception.class})
	@Override
	public List<Productos> listarProductos() {
		return productoDaoImpl.listaProductos();
	}
	@Transactional
	@Override
	public void insertarProducto(Productos productos) {
		productoDaoImpl.insertarProducto(productos);
		
	}

	@Transactional
	@Override
	public void eliminarProducto(int id) {
		productoDaoImpl.eliminarProducto(id);
		
	}
	@Transactional
	@Override
	public Productos encontrarProductoPorId(int id) {
		// TODO Auto-generated method stub
		return productoDaoImpl.encontrarProductoPorId(id);
	}
	@Transactional
	@Override
	public void ActualizarProducto(int id, Productos producto) {
		productoDaoImpl.ActualizarProducto(id, producto);
		
	}
	

}
