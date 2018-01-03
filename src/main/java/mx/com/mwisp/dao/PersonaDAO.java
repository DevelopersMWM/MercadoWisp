package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Persona;

public interface PersonaDAO {
	public List<Persona> personList();
	public void insertarPersonaEnDB(Persona persona);
	public Persona findPersonByID(int id);
	public void eliminarPersonaEnDB(int id);
	public void updatePersonInDB(int id,Persona persona);
}
