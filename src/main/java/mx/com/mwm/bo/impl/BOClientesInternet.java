package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Dispositivos;
import mx.com.mwisp.model.Persona;
import mx.com.mwisp.model.Planes;
import mx.com.mwisp.model.Router;
import mx.com.mwisp.model.Sector;
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
		dtoClientes.setApellidoPaterno(cliente.getCliente().getAp_Paterno());
		dtoClientes.setApellidoMaterno(cliente.getCliente().getAp_Materno());
		dtoClientes.setIdMk(cliente.getIdMk());
		dtoClientes.setSector(cliente.getSector().getNombreSector());
		dtoClientes.setIpCliente(cliente.getIp());
		dtoClientes.setFechaInstalacion(cliente.getFechaInslacion());
		dtoClientes.setEquipoInstalado(cliente.getEquipoInstalado().getNombre());
		dtoClientes.setPrimerPago(cliente.getPrimerPago());
		dtoClientes.setEstatus(cliente.getHabilitado());
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
		Persona persona=new Persona();
		persona.setId_Persona(dtoCliente.getIdPersona());
		modelCliente.setCliente(persona);
		//modelCliente.setFolio(dtoCliente.getIdCliente());
		modelCliente.setIdMk(dtoCliente.getIdMk());
		Sector sector=new Sector();
		sector.setIdSector(dtoCliente.getIdSector());
		modelCliente.setSector(sector);
		modelCliente.setDiaCobro(dtoCliente.getDiaCobro());
		modelCliente.setIp(dtoCliente.getIpCliente());
		modelCliente.setFechaInslacion(dtoCliente.getFechaInstalacion());
		Dispositivos equipo=new Dispositivos();
		equipo.setIdEquipo(dtoCliente.getIdEquipo());
		modelCliente.setEquipoInstalado(equipo);
		modelCliente.setPrimerPago(dtoCliente.getPrimerPago());
		Planes plan=new Planes();
		plan.setIdPlan(dtoCliente.getIdPlan());
		modelCliente.setPlan(plan);
		modelCliente.setUbicacion(dtoCliente.getUbicacion());
		Router router=new Router();
		router.setId(dtoCliente.getIdRouter());
		modelCliente.setRouter(router);
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
