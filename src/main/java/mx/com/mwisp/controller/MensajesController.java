package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.MensajeService;
import mx.com.mwm.dto.DTOMensaje;
import mx.com.mwm.dto.helper.FormMensaje;

@Controller
@ManagedBean
@RequestScoped
public class MensajesController {

	@Autowired
	MensajeService mensajeServiceImpl;
	FormMensaje formMensaje;
	public MensajesController() {
		try {
			formMensaje=new FormMensaje();
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
	}
	
	public List<DTOMensaje> listaDeMensajes(){
		formMensaje.setListaDeMensajes(mensajeServiceImpl.listarMensajes());
		return formMensaje.getListaDeMensajes();
	}
	
	public String agregarNuevoMensaje() {
		mensajeServiceImpl.insertarMensaje(new DTOMensaje(formMensaje.getNombreParaMensaje(), formMensaje.getCuerpoMensaje()));
		return "ListaMensajes.xhtml?faces-redirect=true";
	}
	
	public void eliminarMensaje(int id) {
		mensajeServiceImpl.eliminarMensaje(id);
	}
	
	public String editarMensaje() {
		formMensaje.setObtenerIdMensaje(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMensaje"));
		int idMensaje=Integer.parseInt(formMensaje.getObtenerIdMensaje());
		DTOMensaje dtoMensaje=new DTOMensaje();
		dtoMensaje = mensajeServiceImpl.buscarMensajePorID(idMensaje);
		formMensaje.setNombreParaMensaje(dtoMensaje.getNombreDeMensaje());
		formMensaje.setCuerpoMensaje(dtoMensaje.getCuerpoDeMensaje());
		return "EditarMensaje";
	}
	
	public String actualizarMensaje() {
		int idMensaje=Integer.parseInt(formMensaje.getObtenerIdMensaje());
		mensajeServiceImpl.actualizarMensaje(idMensaje, new DTOMensaje(formMensaje.getNombreParaMensaje(), formMensaje.getCuerpoMensaje()));
		return "ListaMensajes.xhtml?faces-redirect=true";
	}

	public FormMensaje getFormMensaje() {
		return formMensaje;
	}

	public void setFormMensaje(FormMensaje formMensaje) {
		this.formMensaje = formMensaje;
	}
	
	
}
