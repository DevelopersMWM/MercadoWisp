package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwisp.controller.PlanController;

public interface PlanService {
	public List<PlanController> listaPlan();
	public void crearPlan(PlanController plan);
	public void eliminarPlan(String idPlan);
}
