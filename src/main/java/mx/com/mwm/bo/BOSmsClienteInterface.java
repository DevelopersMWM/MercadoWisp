package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.SmsCliente;
import mx.com.mwm.dto.DTOSmsCliente;

public interface BOSmsClienteInterface {
	public DTOSmsCliente modelSmsClienteToDTOSmsCliente(SmsCliente modelSmsCliente);
	public List<DTOSmsCliente> listModelSmsClienteToListDtoSmsCliente(List<SmsCliente> listModelSmsCliente);
	public SmsCliente dtoSmsClienteToModelSmscliente(DTOSmsCliente dtoSmsCliente);
	public List<SmsCliente> listDTOSmsClienteToListModelSmsCliente(List<DTOSmsCliente> listDtoSmsCliente);
}
