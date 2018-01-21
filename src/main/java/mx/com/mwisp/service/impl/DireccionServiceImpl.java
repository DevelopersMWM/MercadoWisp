package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.DireccionDAO;
import mx.com.mwisp.model.Direccion;
import mx.com.mwisp.service.DireccionService;
import mx.com.mwm.bo.BODireccionInterface;
import mx.com.mwm.dto.DTODireccion;

@Service
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	DireccionDAO direccioDaoImpl;
	@Autowired
	BODireccionInterface boDireccionImpl;

	@Transactional
	@Override
	public List<DTODireccion> listaDeDirecciones() {
		return boDireccionImpl.listModelDireccionToListDtoDireccion(direccioDaoImpl.listarDirecciones());
	}

	@Transactional
	@Override
	public void agregarDireccion(DTODireccion dtoDireccion) {
		dtoDireccion.setIdPersona(1);;
		Direccion modelDireccion=boDireccionImpl.dtoDireccionToModelDireccion(dtoDireccion);
		direccioDaoImpl.insertarDireccionEnDB(modelDireccion);
	}

	@Transactional
	@Override
	public void eliminarDireccion(int id) {
		direccioDaoImpl.eliminarDireccionEnDB(id);
	}

	@Transactional
	@Override
	public DTODireccion encontrarDireccionPorId(int id) {
		// TODO Auto-generated method stub
		return boDireccionImpl.modeloDireccionToDtoDireccion(direccioDaoImpl.encontrarDireccionPorId(id));
	}

	@Transactional
	@Override
	public void actualizarDireccion(int id, DTODireccion direccion) {
		// TODO Auto-generated method stub
		Direccion modelDireccion=boDireccionImpl.dtoDireccionToModelDireccion(direccion);
		direccioDaoImpl.actualizarDireccionEnDB(id, modelDireccion);
	}

}
