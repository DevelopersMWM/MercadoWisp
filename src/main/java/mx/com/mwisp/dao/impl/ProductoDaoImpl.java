package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.dao.ProductoDao;
import mx.com.mwisp.model.Categoria;
import mx.com.mwisp.model.Productos;

@Repository
public class ProductoDaoImpl implements ProductoDao {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	//este metodo hace una consulta a la base de datos y retorna una lista de productos
	@SuppressWarnings("unchecked")
	@Override
	public List<Productos> listaProductos() {
		// TODO Auto-generated method stub
		Query queryObj = em.createQuery("SELECT p FROM Productos p");
		// return emf.createQuery("SELECT p FROM Productos p").getResultList();
		List<Productos> productosLista = (List<Productos>) queryObj.getResultList();
		if (productosLista != null && productosLista.size() > 0) {
			return productosLista;
		} else {
			return null;
		}
	}
	@Override
	public void insertarProducto(Productos productos) {
		Categoria categoria=em.find(Categoria.class, 1);
		productos.setCategoria(categoria);
		em.persist(productos);		
	}

	@Override
	public void eliminarProducto(int id) {
		Productos producto=em.find(Productos.class, id);
		em.remove(producto);
	}

}
