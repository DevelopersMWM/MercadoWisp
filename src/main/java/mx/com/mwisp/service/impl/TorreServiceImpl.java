package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.TorreDAO;
import mx.com.mwisp.model.Torre;
import mx.com.mwisp.service.TorreService;
import mx.com.mwm.bo.BOTorresInterface;
import mx.com.mwm.dto.DTOTorres;

@Service
public class TorreServiceImpl implements TorreService {
	
	@Autowired
	TorreDAO torreDaoImpl;
	@Autowired
	BOTorresInterface boTorreImpl;

	@Transactional
	@Override
	public void agregarTorre(DTOTorres torre) {
		Torre modelTorre=boTorreImpl.dtoTorreToModelTorre(torre);
		torreDaoImpl.guardarTorreEnDB(modelTorre);
	}

	@Transactional
	@Override
	public void eliminarTorre(int id) {
		torreDaoImpl.eliminarTorre(id);

	}

	@Override
	public void actualizarTorre(int id, DTOTorres torre) {
		Torre modelTorre=boTorreImpl.dtoTorreToModelTorre(torre);
		torreDaoImpl.actualizarTorre(id, modelTorre);
	}

	@Transactional
	@Override
	public List<DTOTorres> listaTorres() {
		return boTorreImpl.listModelTorreTolistDtoTorre(torreDaoImpl.torreList());
	}

	@Override
	public DTOTorres encontrarTorrePorId(int id) {
		return boTorreImpl.modelTorresToDtoTorres(torreDaoImpl.findTorreById(id));
	}

}
