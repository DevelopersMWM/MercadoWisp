package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.DispositivosDAO;
import mx.com.mwisp.model.Dispositivos;

@Repository
public class DispositivosDAOImpl implements DispositivosDAO {
	
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
	public List<Dispositivos> dispositivosList() {
		Query query=em.createQuery("select r from Dispositivos r");
		List<Dispositivos> dispositivosList=(List<Dispositivos>) query.getResultList();
		return dispositivosList;
	}

	@Override
	public void guardarDispositivoEnBD(Dispositivos device) {
		em.persist(device);
//		em.contains(device);
//		return device.getIdEquipo();
	}

	@Override
	public void eliminarDispositivoEnBD(int id) {
		Dispositivos dispositivo=em.find(Dispositivos.class, id);
		em.remove(dispositivo);
	}

	@Override
	public void actualizarDispositivoEnBD(int id, Dispositivos device) {
		device.setIdEquipo(id);
		em.merge(device);
	}

	@Override
	public Dispositivos encontrarDispositivoEnBDPorId(int id) {
		Dispositivos dispositivo=em.find(Dispositivos.class, id);
		return dispositivo;
	}

}
