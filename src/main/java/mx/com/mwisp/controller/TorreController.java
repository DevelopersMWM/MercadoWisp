package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.TorreService;
import mx.com.mwm.dto.DTOTorres;
import mx.com.mwm.dto.helper.FormTorres;

@Controller
@ManagedBean
@RequestScoped
public class TorreController {
	@Autowired
	TorreService torreServiceImpl;
	
	FormTorres formTorre;
	
	public TorreController() {
		try {
			formTorre=new FormTorres();
		}catch(Exception e) {
			System.out.println("Error!! "+e.getMessage());
		}
	}
	
	public List<DTOTorres> torresList(){
		formTorre.setTorresList(torreServiceImpl.listaTorres());
		return formTorre.getTorresList();
	}
	
	
	public FormTorres getFormTorre() {
		return formTorre;
	}

	public void setFormTorre(FormTorres formTorre) {
		this.formTorre = formTorre;
	}
	
	
}
