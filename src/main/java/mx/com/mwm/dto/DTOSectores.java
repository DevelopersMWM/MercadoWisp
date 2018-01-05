package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOSectores implements Serializable {
	
	private static final long serialVersionUID = -760192321438669619L;
	
	private int idSector;
	private String nombreSector;
	private String torre;

	private int idTorre;
	
	public DTOSectores() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTOSectores(String nombreSector, int idTorre) {
		super();
		this.nombreSector = nombreSector;
		this.setIdTorre(idTorre);
	}

	public DTOSectores(int idSector, String nombreSector) {
		super();
		this.idSector = idSector;
		this.nombreSector = nombreSector;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getNombreSector() {
		return nombreSector;
	}

	public void setNombreSector(String nombreSector) {
		this.nombreSector = nombreSector;
	}

	public String getTorre() {
		return torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	@Override
	public String toString() {
		return "DTOSectores [idSector=" + idSector + ", nombreSector=" + nombreSector + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSector;
		result = prime * result + ((nombreSector == null) ? 0 : nombreSector.hashCode());
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
		DTOSectores other = (DTOSectores) obj;
		if (idSector != other.idSector)
			return false;
		if (nombreSector == null) {
			if (other.nombreSector != null)
				return false;
		} else if (!nombreSector.equals(other.nombreSector))
			return false;
		return true;
	}

	public int getIdTorre() {
		return idTorre;
	}

	public void setIdTorre(int idTorre) {
		this.idTorre = idTorre;
	}
}
