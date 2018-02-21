package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOSmsCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3600256072810518162L;

	private int idSmsParacliente;
	private String idServicioSms;
	private String status;
	private String cliente;
	private String mensaje;
	private int idMensaje;
	private int idCliente;
	
	public DTOSmsCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTOSmsCliente(int idCliente,int idMensaje) {
		super();
		this.idMensaje = idMensaje;
		this.idCliente=idCliente;
	}

	public int getIdSmsParacliente() {
		return idSmsParacliente;
	}

	public void setIdSmsParacliente(int idSmsParacliente) {
		this.idSmsParacliente = idSmsParacliente;
	}

	public String getIdServicioSms() {
		return idServicioSms;
	}

	public void setIdServicioSms(String idServicioSms) {
		this.idServicioSms = idServicioSms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "DTOSmsCliente [idSmsParacliente=" + idSmsParacliente + ", idServicioSms=" + idServicioSms + ", status="
				+ status + ", cliente=" + cliente + ", mensaje=" + mensaje + ", idMensaje=" + idMensaje + ", idCliente="
				+ idCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + idCliente;
		result = prime * result + idMensaje;
		result = prime * result + ((idServicioSms == null) ? 0 : idServicioSms.hashCode());
		result = prime * result + idSmsParacliente;
		result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		DTOSmsCliente other = (DTOSmsCliente) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (idMensaje != other.idMensaje)
			return false;
		if (idServicioSms == null) {
			if (other.idServicioSms != null)
				return false;
		} else if (!idServicioSms.equals(other.idServicioSms))
			return false;
		if (idSmsParacliente != other.idSmsParacliente)
			return false;
		if (mensaje == null) {
			if (other.mensaje != null)
				return false;
		} else if (!mensaje.equals(other.mensaje))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
