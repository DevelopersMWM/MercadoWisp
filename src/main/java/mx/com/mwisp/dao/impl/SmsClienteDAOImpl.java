package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.SmsClienteDAO;
import mx.com.mwisp.model.SmsCliente;

@Repository
public class SmsClienteDAOImpl implements SmsClienteDAO {

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
	public List<SmsCliente> listarSmsClientes() {
		Query query=em.createQuery("select r from SmsCliente r");
		List<SmsCliente> listaDeSmsEnviados=(List<SmsCliente>) query.getResultList();
		return listaDeSmsEnviados;
	}

	@Override
	public void guardarSmsACliente(SmsCliente smsCliente) {
		em.persist(smsCliente);
	}

	@Override
	public void eliminarSmsAClienteEnDB(int id) {
		SmsCliente smsCliente=em.find(SmsCliente.class, id);
		em.remove(smsCliente);
	}

	@Override
	public SmsCliente findSmsAClienteById(int id) {
		SmsCliente smsCliente=em.find(SmsCliente.class, id);
		return smsCliente;
	}

	@Override
	public void actualizarSmsACliente(int id, SmsCliente smsACliente) {
		smsACliente.setIdSms(id);
		em.merge(smsACliente);
	}

}
