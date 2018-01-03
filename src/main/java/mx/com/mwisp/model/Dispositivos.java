package mx.com.mwisp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_dispositivos")
public class Dispositivos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Dispositivos")
	private int idEquipo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Modelo")
	private String modelo;
	
	public Dispositivos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dispositivos(String nombre, String modelo) {
		super();
		this.nombre = nombre;
		this.modelo = modelo;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
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
	public String toString() {
		return "Dispositivos [idEquipo=" + idEquipo + ", nombre=" + nombre + ", modelo=" + modelo + "]";
	}
}
