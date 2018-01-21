package mx.com.mwisp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_cliente_servicio")
public class ClienteInternet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Cliente_Servicio")
	private int Folio;
	
	@ManyToOne
	@JoinColumn(name="Cliente")
	private Persona cliente;
	
	@Column(name="id_Mk")
	private String idMk;
	
	@ManyToOne
	@JoinColumn(name="Sector")
	private Sector sector;
	
	@Column(name="Ip")
	private String ip;
	
	@Column(name="Fecha_Instalacion")
	@Temporal(TemporalType.DATE)
	private Date fechaInslacion;
	
	@ManyToOne
	@JoinColumn(name="Equipo_Instalado")
	private Dispositivos equipoInstalado;
	
	@Column(name="Primer_Pago")
	@Temporal(TemporalType.DATE)
	private Date primerPago;
	
	@ManyToOne
	@JoinColumn(name="Plan")
	private Planes plan;
	
	@Column(name="Dia_Cobro")
	private String diaCobro;
	
	@Column(name="Ubicacion")
	private String ubicacion;
	
	@ManyToOne
	@JoinColumn(name="Router")
	private Router router;

	public ClienteInternet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteInternet(Persona cliente, String idMk, Sector sector, String ip, Date fechaInslacion,
			Dispositivos equipoInstalado, Date primerPago, Planes plan, String diaCobro, String ubicacion,
			Router router) {
		super();
		this.cliente = cliente;
		this.idMk = idMk;
		this.sector = sector;
		this.ip = ip;
		this.fechaInslacion = fechaInslacion;
		this.equipoInstalado = equipoInstalado;
		this.primerPago = primerPago;
		this.plan = plan;
		this.diaCobro = diaCobro;
		this.ubicacion = ubicacion;
		this.router = router;
	}

	public int getFolio() {
		return Folio;
	}

	public void setFolio(int folio) {
		Folio = folio;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public String getIdMk() {
		return idMk;
	}

	public void setIdMk(String idMk) {
		this.idMk = idMk;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getFechaInslacion() {
		return fechaInslacion;
	}

	public void setFechaInslacion(Date fechaInslacion) {
		this.fechaInslacion = fechaInslacion;
	}

	public Dispositivos getEquipoInstalado() {
		return equipoInstalado;
	}

	public void setEquipoInstalado(Dispositivos equipoInstalado) {
		this.equipoInstalado = equipoInstalado;
	}

	public Date getPrimerPago() {
		return primerPago;
	}

	public void setPrimerPago(Date primerPago) {
		this.primerPago = primerPago;
	}

	public Planes getPlan() {
		return plan;
	}

	public void setPlan(Planes plan) {
		this.plan = plan;
	}

	public String getDiaCobro() {
		return diaCobro;
	}

	public void setDiaCobro(String diaCobro) {
		this.diaCobro = diaCobro;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Router getRouter() {
		return router;
	}

	public void setRouter(Router router) {
		this.router = router;
	}

	@Override
	public String toString() {
		return "ClienteInternet [Folio=" + Folio + ", cliente=" + cliente + ", idMk=" + idMk + ", sector=" + sector
				+ ", ip=" + ip + ", fechaInslacion=" + fechaInslacion + ", equipoInstalado=" + equipoInstalado
				+ ", primerPago=" + primerPago + ", plan=" + plan + ", diaCobro=" + diaCobro + ", ubicacion="
				+ ubicacion + ", router=" + router + "]";
	}
}
