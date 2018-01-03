package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.PersonaDAO;
import mx.com.mwisp.model.Persona;
import mx.com.mwisp.service.PersonaService;
import mx.com.mwm.bo.BOPersonaInterface;
import mx.com.mwm.dto.DTOPersona;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	PersonaDAO personaDaoImpl;
	@Autowired
	BOPersonaInterface boPersonaImpl;
	
	@Override
	@Transactional
	public void insertarPersona(DTOPersona dtoPersona) {
		Persona modelPersona=boPersonaImpl.dtoPersonaToModelPersona(dtoPersona);
		personaDaoImpl.insertarPersonaEnDB(modelPersona);
	}

	@Override
	@Transactional
	public List<DTOPersona> listarPersona() {
		return boPersonaImpl.listMoldelPersonaTolistDtoPersona(personaDaoImpl.personList());
	}

	@Override
	@Transactional
	public void eliminarPersona(int id) {
		personaDaoImpl.eliminarPersonaEnDB(id);
	}

	@Override
	@Transactional
	public void actualizarPersona(int id, DTOPersona dtoPersona) {	
		Persona modelPersona=boPersonaImpl.dtoPersonaToModelPersona(dtoPersona);
		personaDaoImpl.updatePersonInDB(id, modelPersona);
	}

	@Override
	@Transactional
	public DTOPersona buscarPersonaPorID(int id) {
		return boPersonaImpl.modelPersonaToDtoPersona(personaDaoImpl.findPersonByID(id));
	}

}
