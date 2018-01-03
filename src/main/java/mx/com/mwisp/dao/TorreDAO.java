package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Torre;

public interface TorreDAO {
	public List<Torre> torreList();
	public void guardarTorreEnDB(Torre torre);
	public Torre findTorreById(int id);
	public void eliminarTorre(int id);
	public void actualizarTorre(int id,Torre torre);
}
