package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Dispositivos;
import mx.com.mwm.bo.BODispositivosInterface;
import mx.com.mwm.dto.DTODispositivos;

@Component("boDispositivos")
@Scope("prototype")
public class BODisposivos implements BODispositivosInterface {

	@Override
	public DTODispositivos modelDispositivosToDTODispositivos(Dispositivos modelDispositivo) {
		DTODispositivos dtoDispositivos=new DTODispositivos();
		dtoDispositivos.setIdDispositivo(modelDispositivo.getIdEquipo());
		dtoDispositivos.setNombre(modelDispositivo.getNombre());
		dtoDispositivos.setModelo(modelDispositivo.getModelo());
		return dtoDispositivos;
	}

	@Override
	public List<DTODispositivos> listModelDispositivosToListDTODispositivos(List<Dispositivos> listModelDispositivos) {
		List<DTODispositivos> listDtoDispositivos=null;
		if(listModelDispositivos!=null) {
			listDtoDispositivos=new ArrayList<DTODispositivos>();
			for(Dispositivos modelDisp:listModelDispositivos) {
				listDtoDispositivos.add(this.modelDispositivosToDTODispositivos(modelDisp));
			}
		}
		return listDtoDispositivos;
	}

	@Override
	public Dispositivos dtoDispositivosToModelDispositivos(DTODispositivos dtoDispositivo) {
		Dispositivos modelDisp=new Dispositivos();
		modelDisp.setIdEquipo(dtoDispositivo.getIdDispositivo());
		modelDisp.setNombre(dtoDispositivo.getNombre());
		modelDisp.setModelo(dtoDispositivo.getModelo());
		return modelDisp;
	}

	@Override
	public List<Dispositivos> listDTODispositivosToListModelDispositivos(List<DTODispositivos> listDtoDispositivos) {
		List<Dispositivos> listModelDisp=null;
		if(listDtoDispositivos!=null) {
			listModelDisp=new ArrayList<Dispositivos>();
			for(DTODispositivos dtoDisp:listDtoDispositivos) {
				listModelDisp.add(this.dtoDispositivosToModelDispositivos(dtoDisp));
			}
		}
		return listModelDisp;
	}

}
