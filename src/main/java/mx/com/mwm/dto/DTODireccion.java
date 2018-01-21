package mx.com.mwm.dto;

import java.io.Serializable;

public class DTODireccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2000194043213270622L;
	
	private int idDireccion;
	private int codigoPostal;
	private String calle;
	private String numeroExt;
	private String numeroInt;
	private String estado;
	private String colonia;
	private String municipio;
	private int idPersona;
	private String personaNombre;
	
	
	public DTODireccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTODireccion(int codigoPostal, String calle, String numeroExt, String numeroInt, String estado,
			String colonia, String municipio) {
		super();
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numeroExt = numeroExt;
		this.numeroInt = numeroInt;
		this.estado = estado;
		this.colonia = colonia;
		this.municipio = municipio;
		//this.idPersona = idPersona;
	}


	public DTODireccion(int idDireccion, int codigoPostal, String calle, String numeroExt, String numeroInt,
			String estado, String colonia, String municipio) {
		super();
		this.idDireccion = idDireccion;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numeroExt = numeroExt;
		this.numeroInt = numeroInt;
		this.estado = estado;
		this.colonia = colonia;
		this.municipio = municipio;
	}


	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExt() {
		return numeroExt;
	}
	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}
	public String getNumeroInt() {
		return numeroInt;
	}
	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getPersonaNombre() {
		return personaNombre;
	}

	public void setPersonaNombre(String personaNombre) {
		this.personaNombre = personaNombre;
	}
	
	
}
