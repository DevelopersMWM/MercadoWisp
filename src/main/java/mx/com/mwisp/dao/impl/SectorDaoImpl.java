package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.SectorDao;
import mx.com.mwisp.model.Sector;

@Repository
public class SectorDaoImpl implements SectorDao {

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
	public List<Sector> listaSectores() {
		Query query=em.createQuery("select r from Sector r");
		List<Sector> sectoresList=(List<Sector>) query.getResultList();
		return sectoresList;
	}

}
