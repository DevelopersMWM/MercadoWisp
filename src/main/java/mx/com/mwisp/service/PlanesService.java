package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOPlan;

public interface PlanesService {
	public void agregarPlan(DTOPlan dtoPlan);
	public List<DTOPlan> listarPlanes();
	public void eliminarPlan(int id);
	public void actualizarPlan(int id,DTOPlan dtoPlan);
	public DTOPlan findPlanConId(int id);
}
