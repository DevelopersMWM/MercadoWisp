package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Direccion;
import mx.com.mwm.bo.BOReportePorSectorInterface;
import mx.com.mwm.dto.DTOReportePorSector;

@Component("boReportePorSector")
@Scope("prototype")
public class BOReportePorSector implements BOReportePorSectorInterface {

	@Override
	public DTOReportePorSector modelDireccionYClienteInternetToDtoReporteSector(Direccion direccion, ClienteInternet clienteInter) {
		DTOReportePorSector dtoReportePorSector= new DTOReportePorSector();
		dtoReportePorSector.setFolioCliente(clienteInter.getFolio());
		dtoReportePorSector.setNombre(clienteInter.getCliente().getNombre());
		dtoReportePorSector.setApPat(clienteInter.getCliente().getAp_Paterno());
		dtoReportePorSector.setApMat(clienteInter.getCliente().getAp_Materno());
		dtoReportePorSector.setCalle(direccion.getCalle());
		dtoReportePorSector.setNumInt(direccion.getNumeroInterior());
		dtoReportePorSector.setColonia(direccion.getColonia());
		dtoReportePorSector.setMunicipio(direccion.getMunicipio());
		dtoReportePorSector.setEstado(direccion.getEstado());
		dtoReportePorSector.setTelefono(clienteInter.getCliente().getTelefono());
		dtoReportePorSector.setSector(clienteInter.getSector().getNombreSector());
		dtoReportePorSector.setTorre(clienteInter.getSector().getTorre().getNombre());
		dtoReportePorSector.setIp(clienteInter.getIp());
		return dtoReportePorSector;
	}

	@Override
	public List<DTOReportePorSector> listModeldireccionYClienteInternetToListDtoReporteSector(List<Direccion> listaDirecciones, List<ClienteInternet> listClienteInter) {
		List<DTOReportePorSector> listDtoReportePorSector=null;
		if(listaDirecciones!=null && listClienteInter!=null) {
			listDtoReportePorSector=new ArrayList<DTOReportePorSector>();
			for(ClienteInternet clienteServicio:listClienteInter) {
				for(Direccion direccion:listaDirecciones) {
//					if((direccion.getPersona()==clienteServicio.getCliente())&&(clienteServicio.getSector().getIdSector()==7)) {
					if(direccion.getPersona()==clienteServicio.getCliente()) {
						listDtoReportePorSector.add(this.modelDireccionYClienteInternetToDtoReporteSector(direccion,clienteServicio));
					}
				}
			}
		}
		
		return listDtoReportePorSector;
	}

}
