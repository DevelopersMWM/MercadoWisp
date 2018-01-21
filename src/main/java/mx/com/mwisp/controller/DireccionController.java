package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.DireccionService;
import mx.com.mwm.dto.DTODireccion;
import mx.com.mwm.dto.helper.FormDireccion;

@Controller
@ManagedBean
@RequestScoped
public class DireccionController {
	@Autowired
	DireccionService dirServImpl;
	
	FormDireccion formDir;

	public DireccionController() {
		try {
			formDir=new FormDireccion();
		}catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public List<DTODireccion> listaDeDirecciones(){
		formDir.setListaDirecciones(dirServImpl.listaDeDirecciones());
		return formDir.getListaDirecciones();
	}
	
	public String agregarDireccion() {
		dirServImpl.agregarDireccion(new DTODireccion(Integer.parseInt(formDir.getCodigoPostal()),formDir.getCalle(), formDir.getNumExterior(), formDir.getNumInterior(), formDir.getEstado(), formDir.getColonia(), formDir.getMunicipio()));
		return null;
	}
	
	public FormDireccion getFormDir() {
		return formDir;
	}

	public void setFormDir(FormDireccion formDir) {
		this.formDir = formDir;
	}
	
	
	
	
}
