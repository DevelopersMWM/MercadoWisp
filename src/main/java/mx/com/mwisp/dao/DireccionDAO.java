package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Direccion;
import mx.com.mwisp.model.Persona;

public interface DireccionDAO {
	public List<Direccion> listarDirecciones();
	public void insertarDireccionEnDB(Direccion direccion);
	public void eliminarDireccionEnDB(int id);
	public void actualizarDireccionEnDB(int id,Direccion direccion);
	public Direccion encontrarDireccionPorId(int id);
	public Persona encotrarPersonaPorId(int id);
}
