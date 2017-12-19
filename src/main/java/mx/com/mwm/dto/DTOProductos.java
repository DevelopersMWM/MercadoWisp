package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOProductos implements Serializable{

	/**
	 * Objeto identificador de clase única.
	 */
	private static final long serialVersionUID = -7601923214387669619L;
	
	private int idProducto;
	
	private String nombreProducto;
	
	private float precio;
	
	private String descripcionProducto;
	
	private String tiempoGarantia;
	
	private String categoria;

	public DTOProductos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTOProductos(String nombreProducto, float precio, String descripcionProducto,
			String tiempoGarantia) {
		super();
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcionProducto = descripcionProducto;
		this.tiempoGarantia = tiempoGarantia;
	}

	public DTOProductos(int idProducto, String nombreProducto, float precio, String descripcionProducto,
			String tiempoGarantia) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcionProducto = descripcionProducto;
		this.tiempoGarantia = tiempoGarantia;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getTiempoGarantia() {
		return tiempoGarantia;
	}

	public void setTiempoGarantia(String tiempoGarantia) {
		this.tiempoGarantia = tiempoGarantia;
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "DTOProductos [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio
				+ ", descripcionProducto=" + descripcionProducto + ", tiempoGarantia=" + tiempoGarantia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionProducto == null) ? 0 : descripcionProducto.hashCode());
		result = prime * result + idProducto;
		result = prime * result + ((nombreProducto == null) ? 0 : nombreProducto.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result + ((tiempoGarantia == null) ? 0 : tiempoGarantia.hashCode());
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
		DTOProductos other = (DTOProductos) obj;
		if (descripcionProducto == null) {
			if (other.descripcionProducto != null)
				return false;
		} else if (!descripcionProducto.equals(other.descripcionProducto))
			return false;
		if (idProducto != other.idProducto)
			return false;
		if (nombreProducto == null) {
			if (other.nombreProducto != null)
				return false;
		} else if (!nombreProducto.equals(other.nombreProducto))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (tiempoGarantia == null) {
			if (other.tiempoGarantia != null)
				return false;
		} else if (!tiempoGarantia.equals(other.tiempoGarantia))
			return false;
		return true;
	}
}
