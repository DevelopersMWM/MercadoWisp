package mx.com.mwisp.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_plan_internet")
public class Planes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Plan")
	private int idPlan;
	
	@Column(name="NombrePlan")
	private String nombre;
	
	@Column(name="MBPS_Bajada")
	private String bajada;
	
	@Column(name="MBPS_Subida")
	private String subida;
	
	@Column(name="Costo")
	private float precio;
	
	@Column(name="Fecha_Creacion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	public Planes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planes(String nombre, String bajada, String subida, float precio, Calendar fechaCreacion) {
		super();
		this.nombre = nombre;
		this.bajada = bajada;
		this.subida = subida;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBajada() {
		return bajada;
	}

	public void setBajada(String bajada) {
		this.bajada = bajada;
	}

	public String getSubida() {
		return subida;
	}

	public void setSubida(String subida) {
		this.subida = subida;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
