package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.PlanesService;
import mx.com.mwm.dto.DTOPlan;
import mx.com.mwm.dto.helper.FormPlan;

@Controller
@ManagedBean
@RequestScoped
public class PlanesController {

	@Autowired
	PlanesService planSericeImpl;
	
	FormPlan formPlan;

	public PlanesController() {
		try {
			formPlan=new FormPlan();
		}catch (Exception e) {
			System.out.println("ERROR!:: "+e.getMessage());
		}
	}

	public List<DTOPlan> listarPlanes(){
		formPlan.setListaPlan(planSericeImpl.listarPlanes());
		return formPlan.getListaPlan();
	}
	
	public String agregarPlan() {
		planSericeImpl.agregarPlan(new DTOPlan(formPlan.getNombrePlan(), formPlan.getBajadaPlan(),formPlan.getSubidaPlan(),formPlan.getPrecioPlan(),formPlan.getFechaCreacionPlan()));
		return null;
	}
	
	public void eliminarPlan(int idPlan) {
		planSericeImpl.eliminarPlan(idPlan);
	}
	
	public FormPlan getFormPlan() {
		return formPlan;
	}

	public void setFormPlan(FormPlan formPlan) {
		this.formPlan = formPlan;
	}
	
	
}
