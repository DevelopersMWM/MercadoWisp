package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwm.bo.BOClienteInternetInterface;
import mx.com.mwm.dto.DTOClienteInternet;

@Component("boClienteInternet")
@Scope("prototype")
public class BOClientesInternet implements BOClienteInternetInterface {

	@Override
	public DTOClienteInternet modeloClientetoDtoCliente(ClienteInternet cliente) {
		DTOClienteInternet dtoClientes=new DTOClienteInternet();
		dtoClientes.setIdCliente(cliente.getFolio());
		dtoClientes.setNombreCliente(cliente.getCliente().getNombre());
		dtoClientes.setIdMk(cliente.getIdMk());
		dtoClientes.setSector(cliente.getSector().getNombreSector());
		dtoClientes.setIpCliente(cliente.getIp());
		dtoClientes.setFechaInstalacion(cliente.getFechaInslacion());
		dtoClientes.setEquipoInstalado(cliente.getEquipoInstalado().getNombre());
		dtoClientes.setPrimerPago(cliente.getPrimerPago());
		dtoClientes.setPlan(cliente.getPlan().getNombre());
		dtoClientes.setDiaCobro(cliente.getDiaCobro());
		dtoClientes.setUbicacion(cliente.getUbicacion());
		dtoClientes.setRouter(cliente.getRouter().getNombre());
		return dtoClientes;
	}

	@Override
	public List<DTOClienteInternet> listModeloClienteToListDtoCliente(List<ClienteInternet> listModelCliente) {
		List<DTOClienteInternet> listDtoCliente=null;
		if(listModelCliente!=null) {
			listDtoCliente=new ArrayList<DTOClienteInternet>();
			for(ClienteInternet modelCliente:listModelCliente) {
				listDtoCliente.add(this.modeloClientetoDtoCliente(modelCliente));
			}
		}
		return listDtoCliente;
	}

	@Override
	public ClienteInternet dtoClienteToModelCliente(DTOClienteInternet dtoCliente) {
		ClienteInternet modelCliente =new ClienteInternet();
		modelCliente.setFolio(dtoCliente.getIdCliente());
		modelCliente.setIdMk(dtoCliente.getIdMk());
		modelCliente.setDiaCobro(dtoCliente.getDiaCobro());
		modelCliente.setIp(dtoCliente.getIpCliente());
		modelCliente.setFechaInslacion(dtoCliente.getFechaInstalacion());
		modelCliente.setPrimerPago(dtoCliente.getPrimerPago());
		modelCliente.setUbicacion(dtoCliente.getUbicacion());
		return modelCliente;
	}

	@Override
	public List<ClienteInternet> listDtoClienteToListModelCliente(List<DTOClienteInternet> listDtoClient) {
		List<ClienteInternet> listModelCliente=null;
		if(listDtoClient!=null) {
			listModelCliente=new ArrayList<ClienteInternet>();
			for(DTOClienteInternet dtoCliente:listDtoClient) {
				listModelCliente.add(this.dtoClienteToModelCliente(dtoCliente));
			}
		}
		return listModelCliente;
	}

}
