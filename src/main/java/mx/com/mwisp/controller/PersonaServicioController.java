package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClienteInternetService;
import mx.com.mwisp.service.PersonaService;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.DTOPersona;
import mx.com.mwm.dto.helper.FormClienteInternet;
import mx.com.mwm.dto.helper.FormPersona;

@Controller
@ManagedBean
@RequestScoped
public class PersonaServicioController {
	@Autowired
	PersonaService personaServicio;
	@Autowired
	ClienteInternetService clienteService;
	
	FormPersona formPersona;
	FormClienteInternet formCliente;
	
	public PersonaServicioController() {
		super();
		try {
			formPersona = new FormPersona();
			formCliente = new FormClienteInternet();
		} catch (Exception e) {
			System.out.println("Ocurrió un error!!" + e.getMessage());
		}
	}
	
	public List<DTOClienteInternet> listaDeClientes(){
		formCliente.setListClientes(clienteService.listaClientes());
		return formCliente.getListClientes();
	}
	
	public List<DTOPersona> listaPersonas(){
		formPersona.setListPersona(personaServicio.listarPersona());
		return formPersona.getListPersona();
	}
	
	public String guardarPersona() {
		personaServicio.insertarPersona(new DTOPersona(formPersona.getNombre(), formPersona.getApellidoPat(), formPersona.getApellidoMat(), formPersona.getTelefono()));
		return null;//aqui redirige a la misma pagina
	}
	
	public void eliminarPersona(int id) {
		personaServicio.eliminarPersona(id);
	}
	
	public String actualizarPersona() {
		int id=Integer.parseInt(formPersona.getOtenerId());
		personaServicio.actualizarPersona(id, new DTOPersona(formPersona.getNombre(), formPersona.getApellidoPat(), formPersona.getApellidoMat(), formPersona.getTelefono()));
		return null;
	}
	
	public String editarPersona() {
		formPersona.setOtenerId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPersonaId"));
		int id=Integer.parseInt(formPersona.getOtenerId());
		DTOPersona dtoPersona=new DTOPersona();
		dtoPersona=personaServicio.buscarPersonaPorID(id);
		formPersona.setNombre(dtoPersona.getNombrePersona());
		formPersona.setApellidoPat(dtoPersona.getApPaterno());
		formPersona.setApellidoMat(dtoPersona.getApMaterno());
		formPersona.setTelefono(dtoPersona.getTelPersona());
		return null;
	}
	public FormPersona getFormPersona() {
		return formPersona;
	}
	public void setFormPersona(FormPersona formPersona) {
		this.formPersona = formPersona;
	}
	public FormClienteInternet getFormCliente() {
		return formCliente;
	}
	public void setFormCliente(FormClienteInternet formCliente) {
		this.formCliente = formCliente;
	}
	
	
}
