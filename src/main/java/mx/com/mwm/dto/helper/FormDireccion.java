package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTODireccion;

public class FormDireccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9101802828944944614L;
	
	private String codigoPostal;
	private String calle;
	private String numExterior;
	private String numInterior;
	private String estado;
	private String colonia;
	private String municipio;
	private String idPersona;
	List<DTODireccion> listaDirecciones;
	
	public List<DTODireccion> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<DTODireccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	private String obtenerIdDireccion;

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
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

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getObtenerIdDireccion() {
		return obtenerIdDireccion;
	}

	public void setObtenerIdDireccion(String obtenerIdDireccion) {
		this.obtenerIdDireccion = obtenerIdDireccion;
	}
}
