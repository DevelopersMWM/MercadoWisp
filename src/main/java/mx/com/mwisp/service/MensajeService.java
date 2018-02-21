package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOMensaje;

public interface MensajeService {
	
	public void insertarMensaje(DTOMensaje dtoMensaje);
	public List<DTOMensaje> listarMensajes();
	public void eliminarMensaje(int id);
	public void actualizarMensaje(int id,DTOMensaje dtoMensaje);
	public DTOMensaje buscarMensajePorID(int id);
}
