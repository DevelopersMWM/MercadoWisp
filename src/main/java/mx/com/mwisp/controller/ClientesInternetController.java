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
	

	public FormClienteInternet getFormCliente() {
		return formCliente;
	}

	public void setFormCliente(FormClienteInternet formCliente) {
		this.formCliente = formCliente;
	}

}