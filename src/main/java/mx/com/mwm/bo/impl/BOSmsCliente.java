package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Mensaje;
import mx.com.mwisp.model.SmsCliente;
import mx.com.mwm.bo.BOSmsClienteInterface;
import mx.com.mwm.dto.DTOSmsCliente;

@Component("boSmsCliente")
@Scope("prototype")
public class BOSmsCliente implements BOSmsClienteInterface {

	@Override
	public DTOSmsCliente modelSmsClienteToDTOSmsCliente(SmsCliente modelSmsCliente) {
		DTOSmsCliente dtoSmsCliente= new DTOSmsCliente();
		dtoSmsCliente.setIdSmsParacliente(modelSmsCliente.getIdSms());
		dtoSmsCliente.setIdServicioSms(modelSmsCliente.getIdSmsServ());
		dtoSmsCliente.setStatus(modelSmsCliente.getEstatus());
		dtoSmsCliente.setCliente(modelSmsCliente.getCliente().getCliente().getNombre());
		dtoSmsCliente.setMensaje(modelSmsCliente.getMensaje().getCuerpoMensaje());
		return dtoSmsCliente;
	}

	@Override
	public List<DTOSmsCliente> listModelSmsClienteToListDtoSmsCliente(List<SmsCliente> listModelSmsCliente) {
		List<DTOSmsCliente> listDtoCliente=null;
		if(listModelSmsCliente!=null) {
			listDtoCliente=new ArrayList<DTOSmsCliente>();
			for(SmsCliente modelSmsCliente:listModelSmsCliente) {
				listDtoCliente.add(this.modelSmsClienteToDTOSmsCliente(modelSmsCliente));
			}
		}
		return listDtoCliente;
	}

	@Override
	public SmsCliente dtoSmsClienteToModelSmscliente(DTOSmsCliente dtoSmsCliente) {
		SmsCliente modelSmsCliente= new SmsCliente();
		modelSmsCliente.setIdSmsServ(dtoSmsCliente.getIdServicioSms());
		modelSmsCliente.setEstatus(dtoSmsCliente.getStatus());
		Mensaje modelMensaje = new Mensaje();
		modelMensaje.setIdMensaje(dtoSmsCliente.getIdMensaje());
		modelSmsCliente.setMensaje(modelMensaje);
		ClienteInternet clienteInternetModel= new ClienteInternet();
		clienteInternetModel.setFolio(dtoSmsCliente.getIdCliente());
		modelSmsCliente.setCliente(clienteInternetModel);
		
		return modelSmsCliente;
	}

	@Override
	public List<SmsCliente> listDTOSmsClienteToListModelSmsCliente(List<DTOSmsCliente> listDtoSmsCliente) {
		List<SmsCliente> listModelSmsCliente=null;
		if(listDtoSmsCliente!=null) {
			listModelSmsCliente=new ArrayList<SmsCliente>();
			for(DTOSmsCliente dtoSmsCliente:listDtoSmsCliente) {
				listModelSmsCliente.add(this.dtoSmsClienteToModelSmscliente(dtoSmsCliente));
			}
		}
		return listModelSmsCliente;
	}

}
