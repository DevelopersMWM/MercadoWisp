package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Planes;

public interface PlanDAO {
	public List<Planes> listaPlanes();
	public void insertarPlanEnDB(Planes plan);
	public Planes findPlanPorId(int id);
	public void eliminarPlanEnDB(int id);
	public void actualizarPlanEnDB(int id,Planes plan);
}
