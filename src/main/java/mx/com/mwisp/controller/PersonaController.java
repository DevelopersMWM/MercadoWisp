package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.PersonaService;
import mx.com.mwm.dto.DTOPersona;
import mx.com.mwm.dto.helper.FormPersona;
import mx.com.mwm.dto.helper.FormRouter;

@Controller
@ManagedBean
@RequestScoped
public class PersonaController {
	@Autowired
	PersonaService personaServiceImpl;

	FormPersona formPersona;

	public PersonaController() {
		try {
			formPersona = new FormPersona();
		} catch (Exception e) {
			System.out.println("Ocurrió un error!!" + e.getMessage());
		}
	}
	
	public List<DTOPersona> listaPersonas(){
		formPersona.setListPersona(personaServiceImpl.listarPersona());
		return formPersona.getListPersona();
	}
	
	public String guardarPersona() {
		personaServiceImpl.insertarPersona(new DTOPersona(formPersona.getNombre(), formPersona.getApellidoPat(), formPersona.getApellidoMat(), formPersona.getTelefono()));
		return null;
	}
	
	public void eliminarPersona(int id) {
		personaServiceImpl.eliminarPersona(id);
	}
	
	public String actualizarPersona() {
		int id=Integer.parseInt(formPersona.getOtenerId());
		personaServiceImpl.actualizarPersona(id, new DTOPersona(formPersona.getNombre(), formPersona.getApellidoPat(), formPersona.getApellidoMat(), formPersona.getTelefono()));
		return null;
	}
	
	public String editarPersona() {
		formPersona.setOtenerId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPersonaId"));
		int id=Integer.parseInt(formPersona.getOtenerId());
		DTOPersona dtoPersona=new DTOPersona();
		dtoPersona=personaServiceImpl.buscarPersonaPorID(id);
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
	
	

}
