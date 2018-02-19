package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTOSmsCliente;

public class FormSmsCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2342694361423271278L;

	private String idMensaje;
	private String idCliente;
	private String Nombre;
	private String ApePat;
	private String ApeMat;
	private String Telefono;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApePat() {
		return ApePat;
	}
	public void setApePat(String apePat) {
		ApePat = apePat;
	}
	public String getApeMat() {
		return ApeMat;
	}
	public void setApeMat(String apeMat) {
		ApeMat = apeMat;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	List<DTOSmsCliente> listaDeMensajes;
	
	public String getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public List<DTOSmsCliente> getListaDeMensajes() {
		return listaDeMensajes;
	}
	public void setListaDeMensajes(List<DTOSmsCliente> listaDeMensajes) {
		this.listaDeMensajes = listaDeMensajes;
	}
}
