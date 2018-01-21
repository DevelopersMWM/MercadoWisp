package mx.com.mwm.dto;

import java.io.Serializable;
import java.util.Date;

public class DTOClienteInternet implements Serializable {
	private static final long serialVersionUID = -76019232143866961L;

	public int idCliente;
	public String NombreCliente;
	public String idMk;
	public String Sector;
	public String ipCliente;
	public Date fechaInstalacion;
	public String equipoInstalado;
	public Date primerPago;
	public String plan;
	public String diaCobro;
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
	
	public DTOClienteInternet(String ipCliente, Date fechaInstalacion, Date primerPago, String diaCobro,
			String ubicacion, int idSector, int idEquipo, int idPlan, int idRouter) {
		super();
		this.ipCliente = ipCliente;
		this.fechaInstalacion = fechaInstalacion;
		this.primerPago = primerPago;
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
			Date primerPago, String diaCobro, String ubicacion) {
		super();
		this.idCliente = idCliente;
		this.idMk = idMk;
		this.ipCliente = ipCliente;
		this.fechaInstalacion = fechaInstalacion;
		this.primerPago = primerPago;
		this.diaCobro = diaCobro;
		this.ubicacion = ubicacion;
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

	@Override
	public String toString() {
		return "DTOClienteInternet [idCliente=" + idCliente + ", NombreCliente=" + NombreCliente + ", idMk=" + idMk
				+ ", Sector=" + Sector + ", ipCliente=" + ipCliente + ", fechaInstalacion=" + fechaInstalacion
				+ ", equipoInstalado=" + equipoInstalado + ", primerPago=" + primerPago + ", plan=" + plan
				+ ", diaCobro=" + diaCobro + ", ubicacion=" + ubicacion + ", Router=" + Router + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NombreCliente == null) ? 0 : NombreCliente.hashCode());
		result = prime * result + ((Router == null) ? 0 : Router.hashCode());
		result = prime * result + ((Sector == null) ? 0 : Sector.hashCode());
		result = prime * result + ((diaCobro == null) ? 0 : diaCobro.hashCode());
		result = prime * result + ((equipoInstalado == null) ? 0 : equipoInstalado.hashCode());
		result = prime * result + ((fechaInstalacion == null) ? 0 : fechaInstalacion.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((idMk == null) ? 0 : idMk.hashCode());
		result = prime * result + ((ipCliente == null) ? 0 : ipCliente.hashCode());
		result = prime * result + ((plan == null) ? 0 : plan.hashCode());
		result = prime * result + ((primerPago == null) ? 0 : primerPago.hashCode());
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
		if (diaCobro == null) {
			if (other.diaCobro != null)
				return false;
		} else if (!diaCobro.equals(other.diaCobro))
			return false;
		if (equipoInstalado == null) {
			if (other.equipoInstalado != null)
				return false;
		} else if (!equipoInstalado.equals(other.equipoInstalado))
			return false;
		if (fechaInstalacion == null) {
			if (other.fechaInstalacion != null)
				return false;
		} else if (!fechaInstalacion.equals(other.fechaInstalacion))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (idMk == null) {
			if (other.idMk != null)
				return false;
		} else if (!idMk.equals(other.idMk))
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
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}
}
