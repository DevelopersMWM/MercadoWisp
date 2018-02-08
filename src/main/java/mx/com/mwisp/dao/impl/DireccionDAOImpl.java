package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.DireccionDAO;
import mx.com.mwisp.model.Direccion;
import mx.com.mwisp.model.Persona;

@Repository
public class DireccionDAOImpl implements DireccionDAO {

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
	public List<Direccion> listarDirecciones() {
		Query query=em.createQuery("select r from Direccion r");
		List<Direccion> direccionesList=(List<Direccion>) query.getResultList();
		return direccionesList;
	}

	@Override
	public void insertarDireccionEnDB(Direccion direccion) {
		em.persist(direccion);
	}

	@Override
	public void eliminarDireccionEnDB(int id) {
		Direccion direccion=em.find(Direccion.class, id);
		em.remove(direccion);
	}

	@Override
	public void actualizarDireccionEnDB(int id, Direccion direccion) {
		direccion.setIdDireccion(id);
		em.merge(direccion);
	}

	@Override
	public Direccion encontrarDireccionPorId(int id) {
		Direccion direccion=em.find(Direccion.class, id);
		return direccion;
	}
	
	@Override
	public Persona encotrarPersonaPorId(int id) {
		Persona persona=em.find(Persona.class, id);
		return persona;
	}
}
