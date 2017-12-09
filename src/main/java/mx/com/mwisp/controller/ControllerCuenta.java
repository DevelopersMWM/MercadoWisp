package mx.com.mwisp.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.model.Cuenta;
import mx.com.mwisp.service.CuentaService;

@Controller
@ManagedBean
@RequestScoped
public class ControllerCuenta {
	@Autowired
	CuentaService cuentaServiceImpl;
	
	
	
	private String usuario="cocodrilo";
	private String password;
	private String mail;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	public void agregarCuenta(ControllerCuenta cuenta) {
		
		cuentaServiceImpl.agregarCuenta(new Cuenta(cuenta.getUsuario(), cuenta.getPassword(), cuenta.getMail()));
		
		
	}
	
}
