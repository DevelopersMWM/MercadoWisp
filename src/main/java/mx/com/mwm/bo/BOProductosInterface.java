package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Productos;
import mx.com.mwm.dto.DTOProductos;

public interface BOProductosInterface {
	
	/**
	 * Metodo que permite convertir de Productos a DTOProductos. 
	 * 
	 * @author Bismark P. Leonardo
	 * @since 18/12/2017
	 * @version 1.1
	 * 
	 * @copyright MWM
	 */
	public DTOProductos modelProductosToDtoProductos(Productos modelProductos);
	
	/**
	 * Metodo que permite convertir una lista de Productos a una lista de DTOProductos. 
	 * 
	 * @author Bismark P. Leonardo
	 * @since 18/12/2017
	 * @version 1.1
	 * 
	 * @copyright MWM
	 */
	public List<DTOProductos> listModelProductosToListDtoProductos(List<Productos> listModelProductos);
	
	/**
	 * Metodo que permite convertir de DTOProductos a Productos. 
	 * 
	 * @author Bismark P. Leonardo
	 * @since 18/12/2017
	 * @version 1.1
	 * 
	 * @copyright MWM
	 */
	public Productos dtoProductosToModelProductos(DTOProductos dtoProductos);
	
	/**
	 * Metodo que permite convertir una lista de DTOProductos a una lista Productos. 
	 * 
	 * @author Bismark P. Leonardo
	 * @since 18/12/2017
	 * @version 1.1
	 * 
	 * @copyright MWM
	 */
	public List<Productos> listDtoProductosToListModelProductos(List<DTOProductos> listDtoProductos);
	
}
