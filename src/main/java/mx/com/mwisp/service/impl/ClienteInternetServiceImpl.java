package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.service.ClienteInternetService;
import mx.com.mwm.bo.BOClienteInternetInterface;
import mx.com.mwm.dto.DTOClienteInternet;

@Service
public class ClienteInternetServiceImpl implements ClienteInternetService {

	@Autowired
	ClienteInternetDAO clienteDaoImpl;
	
	@Autowired
	BOClienteInternetInterface boCliente;
	
	@Transactional(readOnly=true, rollbackFor={Exception.class})
	@Override
	public List<DTOClienteInternet> listaClientes() {
		return boCliente.listModeloClienteToListDtoCliente(clienteDaoImpl.listaClientes());
	}

	@Override
	public void insertarCliente(DTOClienteInternet cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DTOClienteInternet encontrar(int id, DTOClienteInternet cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
