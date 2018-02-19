package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.MensajeDAO;
import mx.com.mwisp.model.Mensaje;

@Repository
public class MensajeDAOImpl implements MensajeDAO {

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
	public List<Mensaje> listarMensajes() {
		Query query=em.createQuery("select r from Mensaje r");
		List<Mensaje> mensajesList=(List<Mensaje>) query.getResultList();
		return mensajesList;
	}

	@Override
	public void guardarMensajeEnDB(Mensaje mensaje) {
		em.persist(mensaje);
	}

	@Override
	public Mensaje findMensajeById(int idMensaje) {
		Mensaje mensaje=em.find(Mensaje.class, idMensaje);
		return mensaje;
	}

	@Override
	public void eliminarMensaje(int id) {
		Mensaje mensaje=em.find(Mensaje.class, id);
		em.remove(mensaje);
	}

	@Override
	public void actualizarMensaje(int id, Mensaje mensaje) {
		mensaje.setIdMensaje(id);
		em.merge(mensaje);
	}

}
