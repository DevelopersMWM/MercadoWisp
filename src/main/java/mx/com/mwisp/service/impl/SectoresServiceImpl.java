package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.SectorDao;
import mx.com.mwisp.model.Sector;
import mx.com.mwisp.service.SectoresService;
import mx.com.mwm.bo.BOSectoresInterface;
import mx.com.mwm.dto.DTOSectores;

@Service
public class SectoresServiceImpl implements SectoresService {
	
	@Autowired
	SectorDao sectorDaoImpl;
	@Autowired
	BOSectoresInterface boSectorImpl;
	
	@Transactional(readOnly=true, rollbackFor= {Exception.class})
	@Override
	public List<DTOSectores> listaDeSectores() {
		return boSectorImpl.listModelSectoresTolistDtoSectores(sectorDaoImpl.listaSectores());
	}

	@Transactional
	@Override
	public void insertarSector(DTOSectores sector) {
		Sector modelSector=boSectorImpl.dtoSectorToModelSector(sector);
		sectorDaoImpl.insertarSectorEnDB(modelSector);
	}

	@Transactional
	@Override
	public void eliminarSector(int id) {
		sectorDaoImpl.eliminarSectorEnDB(id);
	}

	@Transactional
	@Override
	public DTOSectores encontrarSectorPorId(int id) {
		return boSectorImpl.modeloSectoresAToDtoSector(sectorDaoImpl.encontrarSectorPorId(id));
	}

	@Transactional
	@Override
	public void actualizarSector(int id, DTOSectores sector) {
		Sector modelSector=boSectorImpl.dtoSectorToModelSector(sector);
		sectorDaoImpl.actualizarSectorEnDB(id, modelSector);
	}

}
