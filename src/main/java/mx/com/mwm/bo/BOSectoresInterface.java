package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Sector;
import mx.com.mwm.dto.DTOSectores;

public interface BOSectoresInterface {
	public DTOSectores modeloSectoresAToDtoSector(Sector modelSector);
	public List<DTOSectores> listModelSectoresTolistDtoSectores(List<Sector> listModelSector);
	public Sector dtoSectorToModelSector(DTOSectores dtoSector);
	public List<Sector> listDtoSectorToModelSector(List<DTOSectores> listDtoSector);
}
