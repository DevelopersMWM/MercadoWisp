package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Sector;
import mx.com.mwisp.model.Torre;
import mx.com.mwm.bo.BOSectoresInterface;
import mx.com.mwm.dto.DTOSectores;

@Component("boSector")
@Scope("prototype")
public class BOSectores implements BOSectoresInterface {

	@Override
	public DTOSectores modeloSectoresAToDtoSector(Sector modelSector) {
		DTOSectores dtoSector= new DTOSectores();
		dtoSector.setIdSector(modelSector.getIdSector());
		dtoSector.setNombreSector(modelSector.getNombreSector());
		dtoSector.setTorre(modelSector.getTorre().getNombre());
		return dtoSector;
	}

	@Override
	public List<DTOSectores> listModelSectoresTolistDtoSectores(List<Sector> listModelSector) {
		List<DTOSectores> listDtoSectores=null;
		if(listModelSector!=null) {
			listDtoSectores=new ArrayList<DTOSectores>();
			for(Sector modelSectores:listModelSector) {
				listDtoSectores.add(this.modeloSectoresAToDtoSector(modelSectores));
			}
		}
		return listDtoSectores;
	}

	@Override
	public Sector dtoSectorToModelSector(DTOSectores dtoSector) { //en este metodo setteas el id de la torre al sector
		Sector modelSector=new Sector();
		modelSector.setIdSector(dtoSector.getIdSector());
		modelSector.setNombreSector(dtoSector.getNombreSector());
		Torre torre=new Torre();//creas un objeto del tipo torre
		torre.setIdTorre(dtoSector.getIdTorre());//le setteas el id de la torre que recibes en DTO
		modelSector.setTorre(torre);
		return modelSector;
	}

	@Override
	public List<Sector> listDtoSectorToModelSector(List<DTOSectores> listDtoSector) {
		List<Sector> listModelSector=null;
		if(listDtoSector!=null) {
			listModelSector=new ArrayList<Sector>();
			for(DTOSectores dtoSector:listDtoSector) {
				listModelSector.add(this.dtoSectorToModelSector(dtoSector));
			}
		}
		return listModelSector;
	}

}
