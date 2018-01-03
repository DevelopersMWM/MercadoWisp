package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.TorreDAO;
import mx.com.mwisp.model.Torre;

@Repository
public class TorreDAOImpl implements TorreDAO {
	
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
	public List<Torre> torreList() {
		Query query=em.createQuery("select r from Torre r");
		List<Torre> torreList=(List<Torre>)query.getResultList();
		return torreList;
	}

	@Override
	public void guardarTorreEnDB(Torre torre) {
		em.persist(torre);
	}

	@Override
	public Torre findTorreById(int id) {
		Torre torre=em.find(Torre.class,id);
		return torre;
	}

	@Override
	public void eliminarTorre(int id) {
		Torre torre=em.find(Torre.class, id);
		em.remove(torre);
	}

	@Override
	public void actualizarTorre(int id, Torre torre) {
		torre.setIdTorre(id);
		em.merge(torre);
	}

}
