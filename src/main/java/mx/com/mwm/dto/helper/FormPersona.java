package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTOPersona;

public class FormPersona implements Serializable {
	private static final long serialVersionUID = 3354598453584464L;//aqui es el problema
	private String nombre;
	private String apellidoPat;
	private String apellidoMat;
	private String telefono;
	List<DTOPersona> listPersona;
	private String otenerId;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<DTOPersona> getListPersona() {
		return listPersona;
	}
	public void setListPersona(List<DTOPersona> listPersona) {
		this.listPersona = listPersona;
	}
	public String getOtenerId() {
		return otenerId;
	}
	public void setOtenerId(String otenerId) {
		this.otenerId = otenerId;
	}
}
