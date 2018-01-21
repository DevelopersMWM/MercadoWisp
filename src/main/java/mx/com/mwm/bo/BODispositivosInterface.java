package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Dispositivos;
import mx.com.mwm.dto.DTODispositivos;

public interface BODispositivosInterface {
	
	public DTODispositivos modelDispositivosToDTODispositivos(Dispositivos modelDispositivo);
	public List<DTODispositivos> listModelDispositivosToListDTODispositivos(List<Dispositivos> listModelDispositivos);
	public Dispositivos dtoDispositivosToModelDispositivos(DTODispositivos dtoDispositivo);
	public List<Dispositivos> listDTODispositivosToListModelDispositivos(List<DTODispositivos> listDtoDispositivos);
}
