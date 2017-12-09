package mx.com.mwisp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.CuentaDao;
import mx.com.mwisp.model.Cuenta;
import mx.com.mwisp.model.Rol;

@Repository
public class CuentaDaoImpl implements CuentaDao {
	
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insertarCuenta(Cuenta cuenta) {
		Rol rol=em.find(Rol.class, 1);
		cuenta.setRol(rol);
		em.persist(cuenta);
		
	}

}
