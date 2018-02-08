package mx.com.mwisp.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClienteBdMkService;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.DTODireccion;
import mx.com.mwm.dto.DTOPersona;
import mx.com.mwm.dto.helper.FormClienteInternet;
import mx.com.mwm.dto.helper.FormDireccion;
import mx.com.mwm.dto.helper.FormPersona;

@Controller
@ManagedBean
@RequestScoped
public class ClienteBDyMkController {
	@Autowired
	ClienteBdMkService clienteBDMkImpl;

	FormDireccion formDir;
	FormClienteInternet formClienteInternet;
	FormPersona formPersona;

	public ClienteBDyMkController() {
		try {
			formDir=new FormDireccion();
			formClienteInternet=new FormClienteInternet();
			formPersona=new FormPersona();
		}catch (Exception e) {
			System.out.println("ERROR!!!: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public String agregarServicioACliente() {
		clienteBDMkImpl.insertarClienteEnBDYMk(new DTOClienteInternet(formClienteInternet.getIpCliente(),formClienteInternet.getFechaInstalacion(),formClienteInternet.getPrimerPago(), formClienteInternet.getDiaCobro(), formClienteInternet.getUbicacionCliente(), Integer.parseInt(formClienteInternet.getIdSector()), Integer.parseInt(formClienteInternet.getIdEquipo()), Integer.parseInt(formClienteInternet.getIdplan()), Integer.parseInt(formClienteInternet.getIdRouter())), new DTODireccion(Integer.parseInt(formDir.getCodigoPostal()),formDir.getCalle(), formDir.getNumExterior(), formDir.getNumInterior(), formDir.getEstado(), formDir.getColonia(), formDir.getMunicipio()), new DTOPersona(formPersona.getNombre(), formPersona.getApellidoPat(), formPersona.getApellidoMat(), formPersona.getTelefono()));
		return "ListaClientesInternet.xhtml?faces-redirect=true";
	}
	
	public void suspenderServicio() {
		formClienteInternet.setObtenerId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("folioCliente"));
		int folioCliente=Integer.parseInt(formClienteInternet.getObtenerId());
		clienteBDMkImpl.suspenderServicioACliente(folioCliente);
		
	}
	
	public void reactivarServicio() {
		formClienteInternet.setObtenerId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("clienteFolio"));
		int folioCliente=Integer.parseInt(formClienteInternet.getObtenerId());
		clienteBDMkImpl.reactivarServicioACliente(folioCliente);
	}
	
	public void eliminarCliente(int folio) {
		clienteBDMkImpl.eliminarCliente(folio);
	}
	
	public FormDireccion getFormDir() {
		return formDir;
	}
	public void setFormDir(FormDireccion formDir) {
		this.formDir = formDir;
	}
	public FormClienteInternet getFormClienteInternet() {
		return formClienteInternet;
	}
	public void setFormClienteInternet(FormClienteInternet formClienteInternet) {
		this.formClienteInternet = formClienteInternet;
	}
	public FormPersona getFormPersona() {
		return formPersona;
	}
	public void setFormPersona(FormPersona formPersona) {
		this.formPersona = formPersona;
	}
}
