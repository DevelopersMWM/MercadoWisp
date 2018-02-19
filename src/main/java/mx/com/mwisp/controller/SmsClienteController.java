package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClienteInternetService;
import mx.com.mwisp.service.SmsClienteService;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.DTOSmsCliente;
import mx.com.mwm.dto.helper.FormSmsCliente;

@Controller
@ManagedBean
@RequestScoped
public class SmsClienteController {

	@Autowired
	SmsClienteService smsClienteServiceImpl;
	@Autowired
	ClienteInternetService cliente;
	
	FormSmsCliente formSmsCliente;
	
	public SmsClienteController() {
		try {
			formSmsCliente=new FormSmsCliente();
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
	}
	
	public List<DTOSmsCliente> listaSmsACliente(){
		formSmsCliente.setListaDeMensajes(smsClienteServiceImpl.listarMensajesAClientes());
		return formSmsCliente.getListaDeMensajes();
	}
	
	public String mensajeACliente() {
		formSmsCliente.setIdCliente(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClienteSms"));
		int idCliente=Integer.parseInt(formSmsCliente.getIdCliente());
		DTOClienteInternet dtoClienteInternet=new DTOClienteInternet();
		dtoClienteInternet=cliente.encontrarClientePorId(idCliente);
		formSmsCliente.setNombre(dtoClienteInternet.getNombreCliente());
		formSmsCliente.setApePat(dtoClienteInternet.getApellidoPaterno());
		formSmsCliente.setApeMat(dtoClienteInternet.getApellidoMaterno());
		formSmsCliente.setTelefono(dtoClienteInternet.getTelefono());
		return "EnviarMensaje";
	}
	
	public String enviarMensajeACliente() {
		smsClienteServiceImpl.insertarSmsEnviado(new DTOSmsCliente(Integer.parseInt(formSmsCliente.getIdCliente()),Integer.parseInt(formSmsCliente.getIdMensaje())));
		System.out.println("Id Cliente : "+formSmsCliente.getIdCliente());
		int idCliente=Integer.parseInt(formSmsCliente.getIdCliente());
		int idSMS=Integer.parseInt(formSmsCliente.getIdMensaje());
		System.out.println("ID SMS: "+idSMS);
		System.out.println("ID cliente: "+idCliente+"\n Id SMS:"+formSmsCliente.getIdMensaje());
		//smsClienteServiceImpl.insertarSmsEnviado(new DTOSmsCliente(Integer.parseInt(formSmsCliente.getIdMensaje())));
		return "ListaClientesInternet.xhtml?faces-redirect=true";
	}
	
	public void eliminarMensajeDeCliente(int id) {
		smsClienteServiceImpl.eliminarMensajeEnviado(id);
	}
	
	public String actualizarMensajes() {
		smsClienteServiceImpl.actulializarMensajes();
		return "ListaMensaje.xhtml?faces-redirect=true";
	}
	public FormSmsCliente getFormSmsCliente() {
		return formSmsCliente;
	}
	public void setFormSmsCliente(FormSmsCliente formSmsCliente) {
		this.formSmsCliente = formSmsCliente;
	}
	
}
