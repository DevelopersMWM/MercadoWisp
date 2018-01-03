package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTOTorres;

public class FormTorres implements Serializable {
	private static final long serialVersionUID = 3354598457358464L;//aqui es el problema
	private String nombre;
	private String obtenerId;
	private List<DTOTorres> torresList;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObtenerId() {
		return obtenerId;
	}
	public void setObtenerId(String obtenerId) {
		this.obtenerId = obtenerId;
	}
	public List<DTOTorres> getTorresList() {
		return torresList;
	}
	public void setTorresList(List<DTOTorres> torresList) {
		this.torresList = torresList;
	}
	
}
