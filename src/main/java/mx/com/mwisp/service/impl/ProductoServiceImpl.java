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
	

	


	@Transactional
	@Override
	public List<Productos> listarProductos() {
		return productoDaoImpl.listaProductos();
	}
	
	

}
