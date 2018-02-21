package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Mensaje;
import mx.com.mwm.bo.BOMensajeInterface;
import mx.com.mwm.dto.DTOMensaje;

@Component("boMensaje")
@Scope("prototype")
public class BOMensaje implements BOMensajeInterface {

	@Override
	public DTOMensaje modelMensajeToDtoMensaje(Mensaje mensaje) {
		DTOMensaje dtoMensaje=new DTOMensaje();
		dtoMensaje.setIdMensaje(mensaje.getIdMensaje());
		dtoMensaje.setNombreDeMensaje(mensaje.getNombreMensaje());
		dtoMensaje.setCuerpoDeMensaje(mensaje.getCuerpoMensaje());
		return dtoMensaje;
	}

	@Override
	public List<DTOMensaje> listModelMensajeToListDTOMensaje(List<Mensaje> listaModelMensaje) {
		List<DTOMensaje> listDTOMensaje=null;
		if(listaModelMensaje!=null) {
			listDTOMensaje=new ArrayList<DTOMensaje>();
			for(Mensaje modelMensaje:listaModelMensaje) {
				listDTOMensaje.add(this.modelMensajeToDtoMensaje(modelMensaje));
			}
		}
		return listDTOMensaje;
	}

	@Override
	public Mensaje DTOMensajeToModelMensaje(DTOMensaje dtoMensaje) {
		Mensaje modelMensaje=new Mensaje();
		modelMensaje.setIdMensaje(dtoMensaje.getIdMensaje());
		modelMensaje.setNombreMensaje(dtoMensaje.getNombreDeMensaje());
		modelMensaje.setCuerpoMensaje(dtoMensaje.getCuerpoDeMensaje());
		return modelMensaje;
	}

	@Override
	public List<Mensaje> listDTOMensajeToListModelMensaje(List<DTOMensaje> listDTOMensaje) {
		List<Mensaje> listModelMensaje=null;
		if(listDTOMensaje!=null) {
			listModelMensaje=new ArrayList<Mensaje>();
			for(DTOMensaje dtoMensaje:listDTOMensaje) {
				listModelMensaje.add(this.DTOMensajeToModelMensaje(dtoMensaje));
			}
		}
		return listModelMensaje;
	}

}
