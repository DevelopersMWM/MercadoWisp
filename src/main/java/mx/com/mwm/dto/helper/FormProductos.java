package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTOProductos;

public class FormProductos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 335459845735844464L;
	
	private String nombre;
	private float precio;
	private String descripcion;
	private String garantia;
	
	//variable que pasa el precio
	private String enviarPrecio;
	
	//obtenert el id
	private String obtenerId;
	
	List<DTOProductos> listProductos;

	public List<DTOProductos> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<DTOProductos> listProductos) {
		this.listProductos = listProductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getEnviarPrecio() {
		return enviarPrecio;
	}

	public void setEnviarPrecio(String enviarPrecio) {
		this.enviarPrecio = enviarPrecio;
	}

	public String getObtenerId() {
		return obtenerId;
	}

	public void setObtenerId(String obtenerId) {
		this.obtenerId = obtenerId;
	}
	
}
