package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.MensajeDAO;
import mx.com.mwisp.model.Mensaje;
import mx.com.mwisp.service.MensajeService;
import mx.com.mwm.bo.BOMensajeInterface;
import mx.com.mwm.dto.DTOMensaje;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	MensajeDAO mensajeDaoImpl;
	@Autowired
	BOMensajeInterface boMensajeImpl;
	
	@Transactional
	@Override
	public void insertarMensaje(DTOMensaje dtoMensaje) {
		Mensaje modelMensaje=boMensajeImpl.DTOMensajeToModelMensaje(dtoMensaje);
		mensajeDaoImpl.guardarMensajeEnDB(modelMensaje);
				
	}

	@Transactional
	@Override
	public List<DTOMensaje> listarMensajes() {
		return boMensajeImpl.listModelMensajeToListDTOMensaje(mensajeDaoImpl.listarMensajes());
	}

	@Transactional
	@Override
	public void eliminarMensaje(int id) {
		mensajeDaoImpl.eliminarMensaje(id);
	}

	@Transactional
	@Override
	public void actualizarMensaje(int id, DTOMensaje dtoMensaje) {
		Mensaje modelMensaje=boMensajeImpl.DTOMensajeToModelMensaje(dtoMensaje);
		mensajeDaoImpl.actualizarMensaje(id, modelMensaje);
	}

	@Transactional
	@Override
	public DTOMensaje buscarMensajePorID(int id) {
		return boMensajeImpl.modelMensajeToDtoMensaje(mensajeDaoImpl.findMensajeById(id));
	}

}
