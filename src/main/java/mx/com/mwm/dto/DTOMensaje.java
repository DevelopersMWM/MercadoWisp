package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOMensaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2371090022658163058L;

	private int idMensaje;
	private String nombreDeMensaje;
	private String cuerpoDeMensaje;
	
	public DTOMensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTOMensaje(String nombreDeMensaje, String cuerpoDeMensaje) {
		super();
		this.nombreDeMensaje = nombreDeMensaje;
		this.cuerpoDeMensaje = cuerpoDeMensaje;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getNombreDeMensaje() {
		return nombreDeMensaje;
	}

	public void setNombreDeMensaje(String nombreDeMensaje) {
		this.nombreDeMensaje = nombreDeMensaje;
	}

	public String getCuerpoDeMensaje() {
		return cuerpoDeMensaje;
	}

	public void setCuerpoDeMensaje(String cuerpoDeMensaje) {
		this.cuerpoDeMensaje = cuerpoDeMensaje;
	}

	@Override
	public String toString() {
		return "DTOMensaje [idMensaje=" + idMensaje + ", nombreDeMensaje=" + nombreDeMensaje + ", cuerpoDeMensaje="
				+ cuerpoDeMensaje + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuerpoDeMensaje == null) ? 0 : cuerpoDeMensaje.hashCode());
		result = prime * result + idMensaje;
		result = prime * result + ((nombreDeMensaje == null) ? 0 : nombreDeMensaje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOMensaje other = (DTOMensaje) obj;
		if (cuerpoDeMensaje == null) {
			if (other.cuerpoDeMensaje != null)
				return false;
		} else if (!cuerpoDeMensaje.equals(other.cuerpoDeMensaje))
			return false;
		if (idMensaje != other.idMensaje)
			return false;
		if (nombreDeMensaje == null) {
			if (other.nombreDeMensaje != null)
				return false;
		} else if (!nombreDeMensaje.equals(other.nombreDeMensaje))
			return false;
		return true;
	}
}
