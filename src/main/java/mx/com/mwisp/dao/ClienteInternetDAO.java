package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.ClienteInternet;

public interface ClienteInternetDAO {
	public List<ClienteInternet> listaClientes();
	public void guardarClienteEnDB(ClienteInternet cliente);
	public void eliminarClienteEnDB(int id);
	public ClienteInternet findClientById(int id);
	public void actualizarCliente(int id, ClienteInternet cliente);
}
