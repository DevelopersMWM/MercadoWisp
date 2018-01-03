package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ProductoDao;
import mx.com.mwisp.model.Productos;
import mx.com.mwisp.service.ProductoService;
import mx.com.mwm.bo.BOProductosInterface;
import mx.com.mwm.dto.DTOProductos;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired 
	ProductoDao productoDaoImpl;
	
	@Autowired 
	BOProductosInterface boProductosImpl;

	@Transactional(readOnly=true, rollbackFor={Exception.class})
	@Override
	public List<DTOProductos> listarProductos() {
		return boProductosImpl.listModelProductosToListDtoProductos(productoDaoImpl.listaProductos());
	} 
	
	@Transactional
	@Override
	public void insertarProducto(DTOProductos dtoProductos) {
		Productos modelProductos = boProductosImpl.dtoProductosToModelProductos(dtoProductos);
		productoDaoImpl.insertarProducto(modelProductos);
	}

	@Transactional
	@Override
	public void eliminarProducto(int id) {
		productoDaoImpl.eliminarProducto(id);
		
	}
	@Transactional
	@Override
	public DTOProductos encontrarProductoPorId(int id) {
		return boProductosImpl.modelProductosToDtoProductos(productoDaoImpl.encontrarProductoPorId(id));
	}
	@Transactional
	@Override
	public void ActualizarProducto(int id, DTOProductos dtoProductos) {
		Productos modelProductos = boProductosImpl.dtoProductosToModelProductos(dtoProductos);
		productoDaoImpl.ActualizarProducto(id, modelProductos);
		
	}
	

}
