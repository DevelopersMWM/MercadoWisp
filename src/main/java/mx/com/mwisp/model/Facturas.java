package mx.com.mwisp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_factura")
public class Facturas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Factura")
	private int idFactura;
	
	@Column(name="Fecha_Factura")
	private LocalDate fecha;
	
	@Column(name="Monto_Factura")
	private float montoFactura;
	
	@Column(name="Rfc")
	private String rfc;
	
	@OneToOne
	@JoinColumn(name="Fk_Venta")
	private Ventas ventas;
	
	@ManyToOne
	@JoinColumn(name="Fk_Persona")
	private Persona persona;
	
	public Facturas() {
		// TODO Auto-generated constructor stub
	}

	public Facturas(LocalDate fecha, float montoFactura, String rfc) {
		super();
		this.fecha = fecha;
		this.montoFactura = montoFactura;
		this.rfc = rfc;
	}
	

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(float montoFactura) {
		this.montoFactura = montoFactura;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Facturas [idFactura=" + idFactura + ", fecha=" + fecha + ", montoFactura=" + montoFactura + ", rfc="
				+ rfc + ", ventas=" + ventas + ", persona=" + persona + "]";
	}
	
	
	

}
