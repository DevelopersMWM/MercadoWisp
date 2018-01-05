package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTOSectores;

public class FormSectores implements Serializable {
	private static final long serialVersionUID = 33545945735844464L;
	
	private String nombre;
	private String torre;
	private String obtenerId;
	private String idTorre;
	List<DTOSectores> sectoresList;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTorre() {
		return torre;
	}
	public void setTorre(String torre) {
		this.torre = torre;
	}
	public String getObtenerId() {
		return obtenerId;
	}
	public void setObtenerId(String obtenerId) {
		this.obtenerId = obtenerId;
	}
	public List<DTOSectores> getSectoresList() {
		return sectoresList;
	}
	public void setSectoresList(List<DTOSectores> sectoresList) {
		this.sectoresList = sectoresList;
	}
	public String getIdTorre() {
		return idTorre;
	}
	public void setIdTorre(String idTorre) {
		this.idTorre = idTorre;
	}
	
	
}
