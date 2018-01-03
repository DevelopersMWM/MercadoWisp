package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import mx.com.mwm.dto.DTOClienteInternet;

public class FormClienteInternet implements Serializable{
	private static final long serialVersionUID = 3354594573584464L;
	
	private String idMk;
	private String ipCliente;
	private Calendar fechaInstalacion;
	private Calendar primerPago;
	private String diaCobro;
	private String ubicacionCliente;
	List<DTOClienteInternet> listClientes;
	
	private String obtenerId;
	
	public String getIdMk() {
		return idMk;
	}
	public void setIdMk(String idMk) {
		this.idMk = idMk;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}
	public Calendar getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(Calendar fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	public Calendar getPrimerPago() {
		return primerPago;
	}
	public void setPrimerPago(Calendar primerPago) {
		this.primerPago = primerPago;
	}
	public String getDiaCobro() {
		return diaCobro;
	}
	public void setDiaCobro(String diaCobro) {
		this.diaCobro = diaCobro;
	}
	public String getUbicacionCliente() {
		return ubicacionCliente;
	}
	public void setUbicacionCliente(String ubicacionCliente) {
		this.ubicacionCliente = ubicacionCliente;
	}
	public List<DTOClienteInternet> getListClientes() {
		return listClientes;
	}
	public void setListClientes(List<DTOClienteInternet> listClientes) {
		this.listClientes = listClientes;
	}
	public String getObtenerId() {
		return obtenerId;
	}
	public void setObtenerId(String obtenerId) {
		this.obtenerId = obtenerId;
	}
}
