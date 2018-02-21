package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Mensaje;
import mx.com.mwm.dto.DTOMensaje;

public interface BOMensajeInterface {
	public DTOMensaje modelMensajeToDtoMensaje(Mensaje mensaje);
	public List<DTOMensaje> listModelMensajeToListDTOMensaje(List<Mensaje> listaModelMensaje);
	public Mensaje DTOMensajeToModelMensaje(DTOMensaje dtoMensaje);
	public List<Mensaje> listDTOMensajeToListModelMensaje(List<DTOMensaje> listDTOMensaje);
	
}
