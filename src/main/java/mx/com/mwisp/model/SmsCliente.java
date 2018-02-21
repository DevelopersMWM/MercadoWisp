package mx.com.mwisp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_sms_enviado")
public class SmsCliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5707157141458326539L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_sms_enviado")
	private int idSms;
	@Column(name="Id_Servicio")
	private String idSmsServ;
	@Column(name="Estado_sms")
	private String estatus;
	@ManyToOne
	@JoinColumn(name="Mensaje")
	private Mensaje mensaje;
	@ManyToOne
	@JoinColumn(name="Cliente")
	private ClienteInternet cliente;
	
	public SmsCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmsCliente(String idSmsServ, String estatus, Mensaje mensaje, ClienteInternet cliente) {
		super();
		this.idSmsServ = idSmsServ;
		this.estatus = estatus;
		this.mensaje = mensaje;
		this.cliente = cliente;
	}

	public int getIdSms() {
		return idSms;
	}

	public void setIdSms(int idSms) {
		this.idSms = idSms;
	}

	public String getIdSmsServ() {
		return idSmsServ;
	}

	public void setIdSmsServ(String idSmsServ) {
		this.idSmsServ = idSmsServ;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public ClienteInternet getCliente() {
		return cliente;
	}

	public void setCliente(ClienteInternet cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "SmsCliente [idSms=" + idSms + ", idSmsServ=" + idSmsServ + ", estatus=" + estatus + ", mensaje="
				+ mensaje + ", cliente=" + cliente + "]";
	}
	
	
}
