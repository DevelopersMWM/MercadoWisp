package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.DispositivosService;
import mx.com.mwm.dto.DTODispositivos;
import mx.com.mwm.dto.helper.FormDispositivos;

@Controller
@ManagedBean
@RequestScoped
public class DispositivosController {
	
	@Autowired
	DispositivosService serviceDispositivosImpl;
	
	FormDispositivos formDispocitivos;

	public DispositivosController() {
		try {
			formDispocitivos =new FormDispositivos();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<DTODispositivos> listDispositivos(){
		formDispocitivos.setListaDispositivos(serviceDispositivosImpl.listarDispositivos());
		return formDispocitivos.getListaDispositivos();
	}
	
	public FormDispositivos getFormDispocitivos() {
		return formDispocitivos;
	}

	public void setFormDispocitivos(FormDispositivos formDispocitivos) {
		this.formDispocitivos = formDispocitivos;
	}
	
	
}
