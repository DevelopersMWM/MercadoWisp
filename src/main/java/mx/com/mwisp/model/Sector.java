package mx.com.mwisp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sectores")
public class Sector {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idT_Sectores")
	private int idSector;
	
	@Column(name="Nombre")
	private String nombreSector;
	
	@ManyToOne
	@JoinColumn(name="Torre")
	private Torre torre;

	public Sector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sector(String nombreSector) {
		super();
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

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}

	@Override
	public String toString() {
		return "Sector [idSector=" + idSector + ", nombreSector=" + nombreSector + ", torre=" + torre + "]";
	} 
	
	
}
