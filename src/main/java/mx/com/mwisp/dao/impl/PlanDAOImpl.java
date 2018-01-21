package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.PlanDAO;
import mx.com.mwisp.model.Planes;

@Repository
public class PlanDAOImpl implements PlanDAO {
	
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
	public List<Planes> listaPlanes() {
		Query query=em.createQuery("select r from Planes r");
		List<Planes> listaPlanes=(List<Planes>) query.getResultList();
		return listaPlanes;
	}

	@Override
	public void insertarPlanEnDB(Planes plan) {
		em.persist(plan);

	}

	@Override
	public Planes findPlanPorId(int id) {
		Planes plan=em.find(Planes.class, id);
		return plan;
	}

	@Override
	public void eliminarPlanEnDB(int id) {
		Planes plan=em.find(Planes.class, id);
		em.remove(plan);

	}

	@Override
	public void actualizarPlanEnDB(int id, Planes plan) {
		plan.setIdPlan(id);
		em.merge(plan);
		

	}

}
