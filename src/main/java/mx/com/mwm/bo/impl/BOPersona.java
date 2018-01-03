package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Persona;
import mx.com.mwm.bo.BOPersonaInterface;
import mx.com.mwm.dto.DTOPersona;

@Component("boPersona")
@Scope("prototype")
public class BOPersona implements BOPersonaInterface {

	@Override
	public DTOPersona modelPersonaToDtoPersona(Persona modelPersona) {
		DTOPersona dtoPersona=new DTOPersona();
		dtoPersona.setIdPersona(modelPersona.getId_Persona());
		dtoPersona.setNombrePersona(modelPersona.getNombre());
		dtoPersona.setApPaterno(modelPersona.getAp_Paterno());
		dtoPersona.setApMaterno(modelPersona.getAp_Materno());
		dtoPersona.setTelPersona(modelPersona.getTelefono());
		return dtoPersona;
	}

	@Override
	public List<DTOPersona> listMoldelPersonaTolistDtoPersona(List<Persona> listModelPersona) {
		List<DTOPersona> listDtoPersona=null;
		if(listModelPersona!=null) {
			listDtoPersona=new ArrayList<DTOPersona>();
			for(Persona modelPersona:listModelPersona) {
				listDtoPersona.add(this.modelPersonaToDtoPersona(modelPersona));
			}
		}
		return listDtoPersona;
	}

	@Override
	public Persona dtoPersonaToModelPersona(DTOPersona dtoPersona) {
		Persona modelPersona= new Persona();
		modelPersona.setId_Persona(dtoPersona.getIdPersona());
		modelPersona.setNombre(dtoPersona.getNombrePersona());
		modelPersona.setAp_Paterno(dtoPersona.getApPaterno());
		modelPersona.setAp_Materno(dtoPersona.getApMaterno());
		modelPersona.setTelefono(dtoPersona.getTelPersona());
		return modelPersona;
	}

	@Override
	public List<Persona> listDtoPersonaToListModelPersona(List<DTOPersona> listDtoPersona) {
		List<Persona> listModelPersona=null;
		if(listDtoPersona!=null) {
			listModelPersona=new ArrayList<Persona>();
			for(DTOPersona dtoPersona:listDtoPersona) {
				listModelPersona.add(this.dtoPersonaToModelPersona(dtoPersona));
			}
		}
		return listModelPersona;
	}

}
