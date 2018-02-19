package mx.com.mwm.dto;

import java.io.Serializable;
import java.util.Date;

public class DTOClienteInternet implements Serializable {
	private static final long serialVersionUID = -76019232143866961L;

	public int idCliente;
	public String NombreCliente;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String idMk;
	public String Sector;
	public String ipCliente;
	public Date fechaInstalacion;
	public String equipoInstalado;
	public Date primerPago;
	public String email;
	public String plan;
	public Boolean estatus;
	public String diaCobro;
	public String telefono;
	public String ubicacion;
	public String Router;
	public int idPersona;
	public int idSector;
	public int idEquipo;
	public int idPlan;
	public int idRouter;
	
	public DTOClienteInternet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTOClienteInternet(String ipCliente, Date fechaInstalacion, Date primerPago,String email, String diaCobro,
			String ubicacion, int idSector, int idEquipo, int idPlan, int idRouter) {
		super();
		this.ipCliente = ipCliente;
		this.fechaInstalacion = fechaInstalacion;
		this.primerPago = primerPago;
		this.email=email;
		this.diaCobro = diaCobro;
		this.ubicacion = ubicacion;
		this.idSector = idSector;
		this.idEquipo = idEquipo;
		this.idPlan = idPlan;
		this.idRouter = idRouter;
	}


	/*public DTOClienteInternet(String idMk, String ipCliente, Calendar fechaInstalacion, Calendar primerPago,
			String diaCobro, String ubicacion) {
		super();
		this.idMk = idMk;
		this.ipCliente = ipCliente;
		this.fechaInstalacion = fechaInstalacion;
		this.primerPago = primerPago;
		this.diaCobro = diaCobro;
		this.ubicacion = ubicacion;
	}*/

	public DTOClienteInternet(int idCliente, String idMk, String ipCliente, Date fechaInstalacion,
			Date primerPago,String email, Boolean estatus,String diaCobro,String telefono, String ubicacion) {
		super();
		this.idCliente = idCliente;
		this.idMk = idMk;
		this.ipCliente = ipCliente;
		this.fechaInstalacion = fechaInstalacion;
		this.primerPago = primerPago;
		this.email = email;
		this.diaCobro = diaCobro;
		this.telefono = telefono;
		this.ubicacion = ubicacion;
		this.estatus=estatus;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public String getIdMk() {
		return idMk;
	}

	public void setIdMk(String idMk) {
		this.idMk = idMk;
	}

	public String getSector() {
		return Sector;
	}

	public void setSector(String sector) {
		Sector = sector;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public String getEquipoInstalado() {
		return equipoInstalado;
	}

	public void setEquipoInstalado(String equipoInstalado) {
		this.equipoInstalado = equipoInstalado;
	}

	public Date getPrimerPago() {
		return primerPago;
	}

	public void setPrimerPago(Date primerPago) {
		this.primerPago = primerPago;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
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

	public String getRouter() {
		return Router;
	}

	public void setRouter(String router) {
		Router = router;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getIdPlan() {
		return idPlan;
	}
	
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getIdRouter() {
		return idRouter;
	}

	public void setIdRouter(int idRouter) {
		this.idRouter = idRouter;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "DTOClienteInternet [idCliente=" + idCliente + ", NombreCliente=" + NombreCliente + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", idMk=" + idMk + ", Sector=" + Sector
				+ ", ipCliente=" + ipCliente + ", fechaInstalacion=" + fechaInstalacion + ", equipoInstalado="
				+ equipoInstalado + ", primerPago=" + primerPago + ", email=" + email + ", plan=" + plan + ", estatus="
				+ estatus + ", diaCobro=" + diaCobro + ", telefono=" + telefono + ", ubicacion=" + ubicacion
				+ ", Router=" + Router + ", idPersona=" + idPersona + ", idSector=" + idSector + ", idEquipo="
				+ idEquipo + ", idPlan=" + idPlan + ", idRouter=" + idRouter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NombreCliente == null) ? 0 : NombreCliente.hashCode());
		result = prime * result + ((Router == null) ? 0 : Router.hashCode());
		result = prime * result + ((Sector == null) ? 0 : Sector.hashCode());
		result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
		result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
		result = prime * result + ((diaCobro == null) ? 0 : diaCobro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((equipoInstalado == null) ? 0 : equipoInstalado.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaInstalacion == null) ? 0 : fechaInstalacion.hashCode());
		result = prime * result + idCliente;
		result = prime * result + idEquipo;
		result = prime * result + ((idMk == null) ? 0 : idMk.hashCode());
		result = prime * result + idPersona;
		result = prime * result + idPlan;
		result = prime * result + idRouter;
		result = prime * result + idSector;
		result = prime * result + ((ipCliente == null) ? 0 : ipCliente.hashCode());
		result = prime * result + ((plan == null) ? 0 : plan.hashCode());
		result = prime * result + ((primerPago == null) ? 0 : primerPago.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
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
		DTOClienteInternet other = (DTOClienteInternet) obj;
		if (NombreCliente == null) {
			if (other.NombreCliente != null)
				return false;
		} else if (!NombreCliente.equals(other.NombreCliente))
			return false;
		if (Router == null) {
			if (other.Router != null)
				return false;
		} else if (!Router.equals(other.Router))
			return false;
		if (Sector == null) {
			if (other.Sector != null)
				return false;
		} else if (!Sector.equals(other.Sector))
			return false;
		if (apellidoMaterno == null) {
			if (other.apellidoMaterno != null)
				return false;
		} else if (!apellidoMaterno.equals(other.apellidoMaterno))
			return false;
		if (apellidoPaterno == null) {
			if (other.apellidoPaterno != null)
				return false;
		} else if (!apellidoPaterno.equals(other.apellidoPaterno))
			return false;
		if (diaCobro == null) {
			if (other.diaCobro != null)
				return false;
		} else if (!diaCobro.equals(other.diaCobro))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (equipoInstalado == null) {
			if (other.equipoInstalado != null)
				return false;
		} else if (!equipoInstalado.equals(other.equipoInstalado))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fechaInstalacion == null) {
			if (other.fechaInstalacion != null)
				return false;
		} else if (!fechaInstalacion.equals(other.fechaInstalacion))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (idEquipo != other.idEquipo)
			return false;
		if (idMk == null) {
			if (other.idMk != null)
				return false;
		} else if (!idMk.equals(other.idMk))
			return false;
		if (idPersona != other.idPersona)
			return false;
		if (idPlan != other.idPlan)
			return false;
		if (idRouter != other.idRouter)
			return false;
		if (idSector != other.idSector)
			return false;
		if (ipCliente == null) {
			if (other.ipCliente != null)
				return false;
		} else if (!ipCliente.equals(other.ipCliente))
			return false;
		if (plan == null) {
			if (other.plan != null)
				return false;
		} else if (!plan.equals(other.plan))
			return false;
		if (primerPago == null) {
			if (other.primerPago != null)
				return false;
		} else if (!primerPago.equals(other.primerPago))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}
}
