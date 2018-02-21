package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Direccion;
import mx.com.mwm.dto.DTOReportePorSector;

public interface BOReportePorSectorInterface {
	public DTOReportePorSector modelDireccionYClienteInternetToDtoReporteSector(Direccion direccion,ClienteInternet clienteInter);
	public List<DTOReportePorSector> listModeldireccionYClienteInternetToListDtoReporteSector(List<Direccion> listaDirecciones,List<ClienteInternet> listDtoReportePorSector);
}
