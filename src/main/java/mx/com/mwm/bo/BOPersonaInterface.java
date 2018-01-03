package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Persona;
import mx.com.mwm.dto.DTOPersona;

public interface BOPersonaInterface {
	public DTOPersona modelPersonaToDtoPersona(Persona modelPersona);
	public List<DTOPersona> listMoldelPersonaTolistDtoPersona(List<Persona> listModelPersona);
	public Persona dtoPersonaToModelPersona(DTOPersona dtoPersona);
	public List<Persona> listDtoPersonaToListModelPersona(List<DTOPersona> listDtoPersona);
}
