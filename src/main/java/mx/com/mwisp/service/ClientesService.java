package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwisp.controller.ClientesController;

public interface ClientesService {
	public List<ClientesController> listaClientes();
	public void insertarUsuario(ClientesController cliente);
	public void eliminarCliente(String id);
	public void prueba(ClientesController prueba);
}
