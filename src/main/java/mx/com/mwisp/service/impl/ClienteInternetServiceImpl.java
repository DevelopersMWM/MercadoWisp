package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Persona;
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

	@Transactional
	@Override
	public void insertarCliente(DTOClienteInternet dtoCliente) {
		ClienteInternet cliente=boCliente.dtoClienteToModelCliente(dtoCliente);
		Persona persona=new Persona();
		persona.setId_Persona(6);
		cliente.setCliente(persona);
		clienteDaoImpl.guardarClienteEnDB(cliente);
	}

	@Transactional
	@Override
	public void eliminarCliente(int id) {
		clienteDaoImpl.eliminarClienteEnDB(id);
	}

	@Transactional
	@Override
	public DTOClienteInternet encontrarClientePorId(int id) {
		return boCliente.modeloClientetoDtoCliente(clienteDaoImpl.findClientById(id));
	}
	
	@Transactional
	@Override
	public void actualizarCliente(int id, DTOClienteInternet cliente) {
		ClienteInternet modelCliente=boCliente.dtoClienteToModelCliente(cliente);
		clienteDaoImpl.actualizarCliente(id, modelCliente);
	}

}
