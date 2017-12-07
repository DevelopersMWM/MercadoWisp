package mx.com.mwisp.dao.impl;

import java.util.List;
import com.google.common.collect.Lists;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.RouterDao;
import mx.com.mwisp.model.Router;

@Repository
public class RouterDaoImpl implements RouterDao {
	
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
	public List<Router> routerList() {
		Query query=em.createQuery("select r from Router r");
		System.out.println("Mostrando Routers");
		List<Router> routers=(List<Router>) query.getResultList();
		return routers;
	}

}
