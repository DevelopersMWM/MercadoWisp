package mx.com.mwisp.controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClientesService;

@Controller
@RequestScoped
@ManagedBean
public class ClientesController {
	
	@Autowired
	ClientesService serviceCliente;
	
	private String id;
	private String nombre;
	private String ip;
	private String fecha;
	private String plan;
	private Date diaCorte;
	private String sector;
	private String opcionActual;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Date getDiaCorte() {
		return diaCorte;
	}

	public void setDiaCorte(Date diaCorte) {
		this.diaCorte = diaCorte;
	}

	public String getOpcionActual() {
		return opcionActual;
	}
	public void setOpcionActual(String opcionActual) {
		this.opcionActual = opcionActual;
	}
	public List<ClientesController> clientesList(){
		return serviceCliente.listaClientes();
	}
	
	public void insertarCliente(ClientesController cliente) {
		serviceCliente.insertarUsuario(cliente);
	}
	
	public void eliminarCliente(String id) {
		serviceCliente.eliminarCliente(id);
	}
	
	public void pruebas(ClientesController prueba) {
		serviceCliente.prueba(prueba);
	}
}
