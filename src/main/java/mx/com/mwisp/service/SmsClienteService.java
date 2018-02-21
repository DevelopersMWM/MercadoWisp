package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOSmsCliente;

public interface SmsClienteService {
	
	public void insertarSmsEnviado(DTOSmsCliente dtoSmsCliente);
	public List<DTOSmsCliente> listarMensajesAClientes();
	public void eliminarMensajeEnviado(int id);
	public void actualizarSmsACliente(int id,DTOSmsCliente dtoSmscliente);
	public void actulializarMensajes();
	public DTOSmsCliente bucarSMSEnviadoPorId(int id);

}
