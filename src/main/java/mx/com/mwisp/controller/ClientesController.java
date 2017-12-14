package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClientesService;

@Controller
@RequestScoped
@ManagedBean
public class ClientesController {
	/*private SelectItem[] opciones = new SelectItem[]{new SelectItem("01", "Opción 1"),
	        new SelectItem("02", "Opción 2"),
	        new SelectItem("03", "Opción 3")};*/
	 
	    private String opcionActual;
	 
	    /*public SelectItem[] getOpciones() {
	        return opciones;
	    }*/
	 
	    public String getOpcionActual() {
	        return opcionActual;
	    }
	 
	    public void setOpcionActual(String opcionActual) {
	        this.opcionActual = opcionActual;
	    }
	
	@Autowired
	ClientesService serviceCliente;
	
	private String id;
	private String nombre;
	private String ip;
	private String fecha;
	private String plan;
	
	private List<ClientesController> listaClient;
	
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
	
	public List<ClientesController> getListaClient() {
		return listaClient;
	}
	public void setListaClient(List<ClientesController> listaClient) {
		this.listaClient = listaClient;
	}
	public List<ClientesController> clientesList(){
		return serviceCliente.listaClientes();
	}
	
	public List<ClientesController> listByNombre(){
		listaClient = serviceCliente.listaClientes();
		for(ClientesController client: listaClient){
			nombre= client.getNombre();
			System.out.println("\n nombre " + nombre);
		}
		return listaClient;
	}
	
	
}
