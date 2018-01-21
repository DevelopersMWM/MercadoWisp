package mx.com.mwm.dto;

import java.io.Serializable;
import java.util.Calendar;

public class DTOPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2527728632129520191L;
	private int idPlan;
	private String nombrePlan;
	private String bajadaPlan;
	private String subidaPlan;
	private float costoPlan;
	private Calendar fechaCreacion;
	
	public DTOPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTOPlan(String nombrePlan, String bajadaPlan, String subidaPlan, float costoPlan, Calendar fechaCreacion) {
		super();
		this.nombrePlan = nombrePlan;
		this.bajadaPlan = bajadaPlan;
		this.subidaPlan = subidaPlan;
		this.costoPlan = costoPlan;
		this.fechaCreacion = fechaCreacion;
	}



	public DTOPlan(int idPlan, String nombrePlan, String bajadaPlan, String subidaPlan, float costoPlan,
			Calendar fechaCreacion) {
		super();
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		this.bajadaPlan = bajadaPlan;
		this.subidaPlan = subidaPlan;
		this.costoPlan = costoPlan;
		this.fechaCreacion = fechaCreacion;
	}


	public int getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	public String getBajadaPlan() {
		return bajadaPlan;
	}
	public void setBajadaPlan(String bajadaPlan) {
		this.bajadaPlan = bajadaPlan;
	}
	public String getSubidaPlan() {
		return subidaPlan;
	}
	public void setSubidaPlan(String subidaPlan) {
		this.subidaPlan = subidaPlan;
	}
	public float getCostoPlan() {
		return costoPlan;
	}
	public void setCostoPlan(float costoPlan) {
		this.costoPlan = costoPlan;
	}
	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bajadaPlan == null) ? 0 : bajadaPlan.hashCode());
		result = prime * result + Float.floatToIntBits(costoPlan);
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + idPlan;
		result = prime * result + ((nombrePlan == null) ? 0 : nombrePlan.hashCode());
		result = prime * result + ((subidaPlan == null) ? 0 : subidaPlan.hashCode());
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
		DTOPlan other = (DTOPlan) obj;
		if (bajadaPlan == null) {
			if (other.bajadaPlan != null)
				return false;
		} else if (!bajadaPlan.equals(other.bajadaPlan))
			return false;
		if (Float.floatToIntBits(costoPlan) != Float.floatToIntBits(other.costoPlan))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idPlan != other.idPlan)
			return false;
		if (nombrePlan == null) {
			if (other.nombrePlan != null)
				return false;
		} else if (!nombrePlan.equals(other.nombrePlan))
			return false;
		if (subidaPlan == null) {
			if (other.subidaPlan != null)
				return false;
		} else if (!subidaPlan.equals(other.subidaPlan))
			return false;
		return true;
	}
	
}
