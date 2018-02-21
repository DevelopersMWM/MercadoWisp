package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.dao.DireccionDAO;
import mx.com.mwisp.model.ClienteInternet;
import mx.com.mwisp.model.Direccion;
import mx.com.mwisp.service.ReportePorSectorService;
import mx.com.mwm.bo.BOReportePorSectorInterface;
import mx.com.mwm.dto.DTOReportePorSector;

@Service
public class ReportePorSectorImpl implements ReportePorSectorService {

	@Autowired
	DireccionDAO direccionDao;
	@Autowired
	ClienteInternetDAO clienteInterDAO;
	@Autowired 
	BOReportePorSectorInterface boReportePorSector;
	
	@Transactional
	@Override
	public List<DTOReportePorSector> listReporteBySector() {
		List<ClienteInternet> listClienteInter=clienteInterDAO.listaClientes();
		List<Direccion> listDireccion=direccionDao.listarDirecciones();
		return boReportePorSector.listModeldireccionYClienteInternetToListDtoReporteSector(listDireccion, listClienteInter);
	}

}
