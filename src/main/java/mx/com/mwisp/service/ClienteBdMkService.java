package mx.com.mwisp.service;

import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.DTODireccion;
import mx.com.mwm.dto.DTOPersona;

public interface ClienteBdMkService {
	public void insertarClienteEnBDYMk(DTOClienteInternet dtoClienteInternet,DTODireccion dtoDireccion,DTOPersona dtoPersona);
	
}
