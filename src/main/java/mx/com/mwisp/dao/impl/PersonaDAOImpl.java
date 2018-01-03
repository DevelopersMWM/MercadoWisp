package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.PersonaDAO;
import mx.com.mwisp.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> personList() {
		Query query=em.createQuery("select r from Persona r");
		List<Persona> personasList=(List<Persona>) query.getResultList();
		return personasList;
	}

	@Override
	public void insertarPersonaEnDB(Persona persona) {
		em.persist(persona);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("CreadoPesonaNom", persona.getNombre());
	}

	@Override
	public Persona findPersonByID(int id) {
		Persona persona=em.find(Persona.class, id);
		return persona;
	}

	@Override
	public void eliminarPersonaEnDB(int id) {
		Persona persona=em.find(Persona.class, id);
		em.remove(persona);
	}

	@Override
	public void updatePersonInDB(int id, Persona persona) {
		persona.setId_Persona(id);
		em.merge(persona);
	}

}
