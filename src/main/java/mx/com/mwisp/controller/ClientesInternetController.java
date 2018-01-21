package mx.com.mwisp.controller;

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
	
	public List<DTOClienteInternet> listaDeClientes(){
		formCliente.setListClientes(clienteServiceImpl.listaClientes());
		return formCliente.getListClientes();
	}
	
	public String agregarCliente() {
		clienteServiceImpl.insertarCliente(new DTOClienteInternet(formCliente.getIpCliente(),formCliente.getFechaInstalacion(),formCliente.getPrimerPago(), formCliente.getDiaCobro(), formCliente.getUbicacionCliente(), Integer.parseInt(formCliente.getIdSector()), Integer.parseInt(formCliente.getIdEquipo()), Integer.parseInt(formCliente.getIdplan()), Integer.parseInt(formCliente.getIdRouter())));
		/*Calendar cal=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();*/
		//clienteServiceImpl.insertarCliente(new DTOClienteInternet(formCliente.getIpCliente(), Calendar.getInstance().setTime(formCliente.getFechaInstalacion()), Calendar.getInstance().setTime(formCliente.getPrimerPago()),formCliente.getDiaCobro(),formCliente.getUbicacionCliente(),Integer.parseInt(formCliente.getIdSector()),Integer.parseInt(formCliente.getIdEquipo()), Integer.parseInt(formCliente.getIdplan()), Integer.parseInt(formCliente.getIdRouter())));
		//clienteServiceImpl.insertarCliente(new DTOClienteInternet(formCliente.getIpCliente(), cal.setTime(formCliente.getFechaInstalacion()), cal2.setTime(formCliente.getPrimerPago()), formCliente.getDiaCobro(), formCliente.getUbicacionCliente(), Integer.parseInt(formCliente.getIdSector()), Integer.parseInt(formCliente.getIdEquipo()), Integer.parseInt(formCliente.getIdplan()), Integer.parseInt(formCliente.getIdRouter())));
		//clienteServiceImpl.insertarCliente(new DTOClienteInternet(idMk, ipCliente, fechaInstalacion, primerPago, diaCobro, ubicacion));
		return "ListaClientesInternet.xhtml?faces-redirect=true";
	}

	public FormClienteInternet getFormCliente() {
		return formCliente;
	}

	public void setFormCliente(FormClienteInternet formCliente) {
		this.formCliente = formCliente;
	}

}
