package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
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
	
	@Override
	@Transactional
	public void guardarRouterEnDB(Router router) {
		em.persist(router);
		System.out.println("Router Guardado");
	}

	@Override
	public void eliminarRouterEnDB(int id) {
		Router router=em.find(Router.class, id);
		em.remove(router);
	}


	@Override
	public void actulizarRouterEnDB(int id, Router router) {
		router.setId(id);
		em.merge(router);
		//em.refresh(router);
	}


	@Override
	public Router findById(int id) {
		Router router=em.find(Router.class, id);
		return router;
	}

}
