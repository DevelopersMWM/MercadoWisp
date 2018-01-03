package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.ClienteInternetDAO;
import mx.com.mwisp.model.ClienteInternet;

@Repository
public class ClienteInternetDAOImpl implements ClienteInternetDAO {
	
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
	public List<ClienteInternet> listaClientes() {
		Query query=em.createQuery("select r from ClienteInternet r");
		List<ClienteInternet> clientsList=(List<ClienteInternet>) query.getResultList();
		return clientsList;
	}

	@Override
	public void guardarClienteEnDB(ClienteInternet cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarClienteEnDB(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClienteInternet findClientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarCliente(int id, ClienteInternet cliente) {
		// TODO Auto-generated method stub

	}

}
