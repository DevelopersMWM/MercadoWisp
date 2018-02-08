package mx.com.mwisp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClienteInternetService;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.helper.FormClienteInternet;

@Controller
@ManagedBean
@RequestScoped
public class ClientesInternetController {

	@Autowired
	ClienteInternetService clienteServiceImpl;

	FormClienteInternet formCliente;

	public ClientesInternetController() {
		try {
			formCliente = new FormClienteInternet();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<DTOClienteInternet> listaClientesSuspendidos(){
		List<DTOClienteInternet> listClientesActivos=null;
		if(clienteServiceImpl.listaClientes()!=null) {
			listClientesActivos=new ArrayList<DTOClienteInternet>();
			for(DTOClienteInternet clienteActivo:clienteServiceImpl.listaClientes()) {
				if(clienteActivo.getEstatus()==false) {
					listClientesActivos.add(clienteActivo);
				}
			}
			formCliente.setListClientes(listClientesActivos);
		}
		return formCliente.getListClientes();
	}
	public List<DTOClienteInternet> listaClientesActivos(){
		List<DTOClienteInternet> listClientesActivos=null;
		if(clienteServiceImpl.listaClientes()!=null) {
			listClientesActivos=new ArrayList<DTOClienteInternet>();
			for(DTOClienteInternet clienteActivo:clienteServiceImpl.listaClientes()) {
				if(clienteActivo.getEstatus()==true) {
					listClientesActivos.add(clienteActivo);
				}
			}
			formCliente.setListClientes(listClientesActivos);
		}
		return formCliente.getListClientes();
	}
	
	public String agregarCliente() {
		clienteServiceImpl.insertarCliente(new DTOClienteInternet(formCliente.getIpCliente(),formCliente.getFechaInstalacion(),formCliente.getPrimerPago(), formCliente.getDiaCobro(), formCliente.getUbicacionCliente(), Integer.parseInt(formCliente.getIdSector()), Integer.parseInt(formCliente.getIdEquipo()), Integer.parseInt(formCliente.getIdplan()), Integer.parseInt(formCliente.getIdRouter())));
		return "ListaClientesInternet.xhtml?faces-redirect=true";
	}

	public FormClienteInternet getFormCliente() {
		return formCliente;
	}

	public void setFormCliente(FormClienteInternet formCliente) {
		this.formCliente = formCliente;
	}

}
