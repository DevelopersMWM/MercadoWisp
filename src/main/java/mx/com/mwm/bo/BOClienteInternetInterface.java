package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwm.dto.DTOClienteInternet;

public interface BOClienteInternetInterface {
	public DTOClienteInternet modeloClientetoDtoCliente(ClienteInternet cliente);
	public List<DTOClienteInternet> listModeloClienteToListDtoCliente(List<ClienteInternet> listModelCliente);
	public ClienteInternet dtoClienteToModelCliente(DTOClienteInternet dtoCliente);
	public List<ClienteInternet> listDtoClienteToListModelCliente(List<DTOClienteInternet> lidDtoClient);
}
