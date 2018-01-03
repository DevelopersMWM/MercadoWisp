package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOPersona;

public interface PersonaService {
	public void insertarPersona(DTOPersona persona);
	public List<DTOPersona> listarPersona();
	public void eliminarPersona(int id);
	public void actualizarPersona(int id,DTOPersona persona);
	public DTOPersona buscarPersonaPorID(int id);
}
