package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.SmsCliente;

public interface SmsClienteDAO {
	
	public List<SmsCliente> listarSmsClientes();
	public void guardarSmsACliente(SmsCliente smsCliente);
	public void eliminarSmsAClienteEnDB(int id);
	public SmsCliente findSmsAClienteById(int id);
	public void actualizarSmsACliente(int id,SmsCliente smsACliente);
}
