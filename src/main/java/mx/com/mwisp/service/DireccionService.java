package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTODireccion;

public interface DireccionService {
	public List<DTODireccion> listaDeDirecciones();
	public void agregarDireccion(DTODireccion dtoDireccion);
	public void eliminarDireccion(int id);
	public DTODireccion encontrarDireccionPorId(int id);
	public void actualizarDireccion(int id,DTODireccion direccion);
}
