package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import mx.com.mwm.dto.DTOClienteInternet;

public class FormClienteInternet implements Serializable{
	private static final long serialVersionUID = 3354594573584464L;
	
	private String idMk;
	private String ipCliente;
	private Date fechaInstalacion;
	private Date primerPago;
	private String diaCobro;
	private String ubicacionCliente;
	//private String idPersona;
	private String idSector;
	private String idEquipo;
	private String idplan;
	private String idRouter;
	
	public String getIdSector() {
		return idSector;
	}
	public void setIdSector(String idSector) {
		this.idSector = idSector;
	}
	public String getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getIdplan() {
		return idplan;
	}
	public void setIdplan(String idplan) {
		this.idplan = idplan;
	}
	public String getIdRouter() {
		return idRouter;
	}
	public void setIdRouter(String idRouter) {
		this.idRouter = idRouter;
	}
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
	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	public Date getPrimerPago() {
		return primerPago;
	}
	public void setPrimerPago(Date primerPago) {
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
