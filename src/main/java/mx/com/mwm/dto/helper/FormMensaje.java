package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTOMensaje;

public class FormMensaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1484472209297054900L;
	
	private String nombreParaMensaje;
	private String cuerpoMensaje;
	private String obtenerIdMensaje;
	List<DTOMensaje> listaDeMensajes;
	
	public String getNombreParaMensaje() {
		return nombreParaMensaje;
	}
	public void setNombreParaMensaje(String nombreParaMensaje) {
		this.nombreParaMensaje = nombreParaMensaje;
	}
	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}
	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}
	public String getObtenerIdMensaje() {
		return obtenerIdMensaje;
	}
	public void setObtenerIdMensaje(String obtenerIdMensaje) {
		this.obtenerIdMensaje = obtenerIdMensaje;
	}
	public List<DTOMensaje> getListaDeMensajes() {
		return listaDeMensajes;
	}
	public void setListaDeMensajes(List<DTOMensaje> listaDeMensajes) {
		this.listaDeMensajes = listaDeMensajes;
	}
	
	
}
