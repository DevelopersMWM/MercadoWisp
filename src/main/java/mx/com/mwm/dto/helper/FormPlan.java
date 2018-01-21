package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import mx.com.mwm.dto.DTOPlan;

public class FormPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1486596049382802416L;
	
	private String nombrePlan;
	private String subidaPlan;
	private String bajadaPlan;
	private float precioPlan;
	private Calendar fechaCreacionPlan;
	private String obtenerIdPlan;
	List<DTOPlan> listaPlan;
	
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	public String getSubidaPlan() {
		return subidaPlan;
	}
	public void setSubidaPlan(String subidaPlan) {
		this.subidaPlan = subidaPlan;
	}
	public String getBajadaPlan() {
		return bajadaPlan;
	}
	public void setBajadaPlan(String bajadaPlan) {
		this.bajadaPlan = bajadaPlan;
	}
	public float getPrecioPlan() {
		return precioPlan;
	}
	public void setPrecioPlan(float precioPlan) {
		this.precioPlan = precioPlan;
	}
	public Calendar getFechaCreacionPlan() {
		return fechaCreacionPlan;
	}
	public void setFechaCreacionPlan(Calendar fechaCreacionPlan) {
		this.fechaCreacionPlan = fechaCreacionPlan;
	}
	public String getObtenerIdPlan() {
		return obtenerIdPlan;
	}
	public void setObtenerIdPlan(String obtenerIdPlan) {
		this.obtenerIdPlan = obtenerIdPlan;
	}
	public List<DTOPlan> getListaPlan() {
		return listaPlan;
	}
	public void setListaPlan(List<DTOPlan> listaPlan) {
		this.listaPlan = listaPlan;
	}
}
