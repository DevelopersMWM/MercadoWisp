package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Mensaje;

public interface MensajeDAO {
	public List<Mensaje> listarMensajes();
	public void guardarMensajeEnDB(Mensaje mensaje);
	public Mensaje findMensajeById(int idMensaje);
	public void eliminarMensaje(int id);
	public void actualizarMensaje(int id,Mensaje mensaje);
}
