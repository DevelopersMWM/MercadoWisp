package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOClienteInternet;

public interface ClienteInternetService {
	
	public List<DTOClienteInternet> listaClientes();
	public void insertarCliente(DTOClienteInternet cliente);
	public void eliminarCliente(int id);
	public DTOClienteInternet encontrarClientePorId(int id);
	public void actualizarCliente(int id,DTOClienteInternet cliente);
}
