package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOSectores;

public interface SectoresService {
	public List<DTOSectores> listaDeSectores();
	public void insertarSector(DTOSectores sector);
	public void eliminarSector(int id);
	public DTOSectores encontrarSectorPorId(int id);
	public void actualizarSector(int id,DTOSectores sector);
}
