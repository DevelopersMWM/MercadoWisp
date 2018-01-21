package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Direccion;
import mx.com.mwm.dto.DTODireccion;

public interface BODireccionInterface {
	
	public DTODireccion modeloDireccionToDtoDireccion(Direccion modelDireccion);
	public List<DTODireccion> listModelDireccionToListDtoDireccion(List<Direccion> listModelDireccion);
	public Direccion dtoDireccionToModelDireccion(DTODireccion dtoDireccion);
	List<Direccion> listDtoDirecccionToListModelDireccion(List<DTODireccion> listDtoDireccion);
}
