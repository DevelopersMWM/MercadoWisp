package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.PlanService;

@Controller
@RequestScoped
@ManagedBean
public class PlanController {
	@Autowired
	PlanService planService;
	
	private String id;
	private String nombre;
	private String subida;
	private String bajada;
	private String router;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSubida() {
		return subida;
	}
	public void setSubida(String subida) {
		this.subida = subida;
	}
	public String getBajada() {
		return bajada;
	}
	public void setBajada(String bajada) {
		this.bajada = bajada;
	}
	public String getRouter() {
		return router;
	}
	public void setRouter(String router) {
		this.router = router;
	}
	
	public List<PlanController> planList(){
		return planService.listaPlan();
	}
	
}
