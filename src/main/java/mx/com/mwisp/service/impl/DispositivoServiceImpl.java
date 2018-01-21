package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mwisp.dao.DispositivosDAO;
import mx.com.mwisp.model.Dispositivos;
import mx.com.mwisp.service.DispositivosService;
import mx.com.mwm.bo.BODispositivosInterface;
import mx.com.mwm.dto.DTODispositivos;

@Service
public class DispositivoServiceImpl implements DispositivosService {
	@Autowired
	DispositivosDAO dispositivoDaoImpl;
	@Autowired
	BODispositivosInterface boDispositivo;

	@Override
	public void eliminarDispositivo(int id) {
		dispositivoDaoImpl.eliminarDispositivoEnBD(id);
		
	}

	@Override
	public List<DTODispositivos> listarDispositivos() {
		return boDispositivo.listModelDispositivosToListDTODispositivos(dispositivoDaoImpl.dispositivosList());
	}

	@Override
	public DTODispositivos findDispositivoPorId(int id) {
		return boDispositivo.modelDispositivosToDTODispositivos(dispositivoDaoImpl.encontrarDispositivoEnBDPorId(id));
	}

	@Override
	public void insertarDispositivo(DTODispositivos dtoDispositivo) {
		Dispositivos modelDispositivo=boDispositivo.dtoDispositivosToModelDispositivos(dtoDispositivo);
		dispositivoDaoImpl.guardarDispositivoEnBD(modelDispositivo);
	}

	@Override
	public void updateDispositivoPorId(int id, DTODispositivos dtoDispositivo) {
		Dispositivos modelDispositivo=boDispositivo.dtoDispositivosToModelDispositivos(dtoDispositivo);
		dispositivoDaoImpl.actualizarDispositivoEnBD(id, modelDispositivo);
	}

}
