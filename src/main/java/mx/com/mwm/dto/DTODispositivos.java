package mx.com.mwm.dto;

import java.io.Serializable;

public class DTODispositivos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 396765226992462508L;
	private int idDispositivo;
	private String nombre;
	private String modelo;
	
	public DTODispositivos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTODispositivos(int idDispositivo, String nombre, String modelo) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.modelo = modelo;
	}

	public DTODispositivos(String nombre, String modelo) {
		super();
		this.nombre = nombre;
		this.modelo = modelo;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDispositivo;
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		DTODispositivos other = (DTODispositivos) obj;
		if (idDispositivo != other.idDispositivo)
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
