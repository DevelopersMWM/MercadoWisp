package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOTorres implements Serializable{
	private static final long serialVersionUID = -76019231438766969L;//si lago sale mal es aqui :D
	private int idTorre;
	private String nombreTorre;
	
	public DTOTorres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTOTorres(String nombreTorre) {
		super();
		this.nombreTorre = nombreTorre;
	}
	public DTOTorres(int idTorre, String nombreTorre) {
		super();
		this.idTorre = idTorre;
		this.nombreTorre = nombreTorre;
	}
	public int getIdTorre() {
		return idTorre;
	}
	public void setIdTorre(int idTorre) {
		this.idTorre = idTorre;
	}
	public String getNombreTorre() {
		return nombreTorre;
	}
	public void setNombreTorre(String nombreTorre) {
		this.nombreTorre = nombreTorre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTorre;
		result = prime * result + ((nombreTorre == null) ? 0 : nombreTorre.hashCode());
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
		DTOTorres other = (DTOTorres) obj;
		if (idTorre != other.idTorre)
			return false;
		if (nombreTorre == null) {
			if (other.nombreTorre != null)
				return false;
		} else if (!nombreTorre.equals(other.nombreTorre))
			return false;
		return true;
	}
	
	
}
