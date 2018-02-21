package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOReportePorSector implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9164336947578851420L;
	
	private int folioCliente;
	private String nombre;
	private String apPat;
	private String apMat;
	private String calle;
	private String numInt;
	private String colonia;
	private String municipio;
	private String estado;
	private String telefono;
	private String sector;
	private String torre;
	private String ip;
	
	public DTOReportePorSector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFolioCliente() {
		return folioCliente;
	}

	public void setFolioCliente(int folioCliente) {
		this.folioCliente = folioCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPat() {
		return apPat;
	}

	public void setApPat(String apPat) {
		this.apPat = apPat;
	}

	public String getApMat() {
		return apMat;
	}

	public void setApMat(String apMat) {
		this.apMat = apMat;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumInt() {
		return numInt;
	}

	public void setNumInt(String numInt) {
		this.numInt = numInt;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTorre() {
		return torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "DTOReportePorSector [folioCliente=" + folioCliente + ", nombre=" + nombre + ", apPat=" + apPat
				+ ", apMat=" + apMat + ", calle=" + calle + ", numInt=" + numInt + ", colonia=" + colonia
				+ ", municipio=" + municipio + ", estado=" + estado + ", telefono=" + telefono + ", sector=" + sector
				+ ", torre=" + torre + ", ip=" + ip + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apMat == null) ? 0 : apMat.hashCode());
		result = prime * result + ((apPat == null) ? 0 : apPat.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((colonia == null) ? 0 : colonia.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + folioCliente;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numInt == null) ? 0 : numInt.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((torre == null) ? 0 : torre.hashCode());
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
		DTOReportePorSector other = (DTOReportePorSector) obj;
		if (apMat == null) {
			if (other.apMat != null)
				return false;
		} else if (!apMat.equals(other.apMat))
			return false;
		if (apPat == null) {
			if (other.apPat != null)
				return false;
		} else if (!apPat.equals(other.apPat))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (colonia == null) {
			if (other.colonia != null)
				return false;
		} else if (!colonia.equals(other.colonia))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (folioCliente != other.folioCliente)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numInt == null) {
			if (other.numInt != null)
				return false;
		} else if (!numInt.equals(other.numInt))
			return false;
		if (sector == null) {
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (torre == null) {
			if (other.torre != null)
				return false;
		} else if (!torre.equals(other.torre))
			return false;
		return true;
	}
}
