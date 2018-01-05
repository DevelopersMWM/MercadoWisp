package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Torre;
import mx.com.mwm.bo.BOTorresInterface;
import mx.com.mwm.dto.DTOTorres;

@Component("boTorre")
@Scope("prototype")
public class BOTorre implements BOTorresInterface {

	@Override
	public DTOTorres modelTorresToDtoTorres(Torre torre) {
		DTOTorres dtoTorre=new DTOTorres();
		dtoTorre.setIdTorre(torre.getIdTorre());
		dtoTorre.setNombreTorre(torre.getNombre());
		return dtoTorre;
	}

	@Override
	public List<DTOTorres> listModelTorreTolistDtoTorre(List<Torre> listModelTorre) {
		List<DTOTorres> listDtoTorres=null;
		if(listModelTorre!=null) {
			listDtoTorres=new ArrayList<DTOTorres>();
			for(Torre modelTorre:listModelTorre ) {
				listDtoTorres.add(this.modelTorresToDtoTorres(modelTorre));
			}
		}
		return listDtoTorres;
	}

	@Override
	public Torre dtoTorreToModelTorre(DTOTorres dtoTorre) {
		Torre modelTorre= new Torre();
		modelTorre.setIdTorre(dtoTorre.getIdTorre());
		modelTorre.setNombre(dtoTorre.getNombreTorre());
		return modelTorre;
	}

	@Override
	public List<Torre> listDtoTorreToListModelTorre(List<DTOTorres> listDtoTorre) {
		List<Torre> listModelTorre=null;
		if(listDtoTorre!=null) {
			listModelTorre=new ArrayList<Torre>();
			for(DTOTorres dtoTorre: listDtoTorre) {
				listModelTorre.add(this.dtoTorreToModelTorre(dtoTorre));
			}
		}
		return listModelTorre;
	}

}
