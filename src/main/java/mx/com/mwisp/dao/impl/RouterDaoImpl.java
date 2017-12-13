package mx.com.mwisp.dao.impl;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.RouterDao;
import mx.com.mwisp.model.Router;

@Repository
public class RouterDaoImpl implements RouterDao {
	
	@PersistenceContext
	private EntityManager em;
	private EntityTransaction et;

	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	public EntityTransaction getEt() {
		return et;
	}


	public void setEt(EntityTransaction et) {
		this.et = et;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Router> routerList() {
		Query query=em.createQuery("select r from Router r");
		System.out.println("Mostrando Routers");
		List<Router> routers=(List<Router>) query.getResultList();
		return routers;
	}


	
	@Override
	@Transactional
	public void guardarRouterEnDB(Router router) {
		em.persist(router);
		System.out.println("Router Guardado");
	}


	@Override
	public Router findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
