package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Productos;
import mx.com.mwm.bo.BOProductosInterface;
import mx.com.mwm.dto.DTOProductos;

@Component("boProductos")
@Scope("prototype")
public class BOProductos implements BOProductosInterface{
	
	@Override
	public DTOProductos modelProductosToDtoProductos(Productos modelProductos){
		DTOProductos dtoProductos = new DTOProductos();
		dtoProductos.setIdProducto(modelProductos.getIdProdcutos());
		dtoProductos.setNombreProducto(modelProductos.getNombreProducto());
		dtoProductos.setDescripcionProducto(modelProductos.getDescripcion());
		dtoProductos.setPrecio(modelProductos.getPrecio());
		dtoProductos.setTiempoGarantia(modelProductos.getTiempoGarantia());
		dtoProductos.setCategoria(modelProductos.getCategoria().getNombreCategoria());
		return dtoProductos;
	}

	@Override
	public Productos dtoProductosToModelProductos(DTOProductos dtoProductos) {
		Productos modelProductos = new Productos();
		modelProductos.setIdProdcutos(dtoProductos.getIdProducto());
		modelProductos.setNombreProducto(dtoProductos.getNombreProducto());
		modelProductos.setDescripcion(dtoProductos.getDescripcionProducto());
		modelProductos.setPrecio(dtoProductos.getPrecio());
		modelProductos.setTiempoGarantia(dtoProductos.getTiempoGarantia());
		//modelProductos.getCategoria().setNombreCategoria(dtoProductos.getCategoria());
		return modelProductos;
	}

	@Override
	public List<DTOProductos> listModelProductosToListDtoProductos(List<Productos> listModelProductos) {
		List<DTOProductos> listDtoProductos = null;
		if (listModelProductos != null) {
			listDtoProductos = new ArrayList<DTOProductos>();
			for (Productos modelProductos : listModelProductos) {
				listDtoProductos.add(this.modelProductosToDtoProductos(modelProductos));
			}
		}
		return listDtoProductos;
	}

	@Override
	public List<Productos> listDtoProductosToListModelProductos(List<DTOProductos> listDtoProductos) {
		List<Productos> listModelProductos = null;
		if(listDtoProductos != null){
			listModelProductos = new ArrayList<Productos>();
			for (DTOProductos dtoProductos : listDtoProductos) {
				listModelProductos.add(this.dtoProductosToModelProductos(dtoProductos));
			}
		}
		return listModelProductos;
	}
}
