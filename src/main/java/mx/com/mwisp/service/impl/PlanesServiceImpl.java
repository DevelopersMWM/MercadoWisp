package mx.com.mwisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.mwisp.dao.PlanDAO;
import mx.com.mwisp.model.Planes;
import mx.com.mwisp.service.PlanesService;
import mx.com.mwm.bo.BOPlanesInterface;
import mx.com.mwm.dto.DTOPlan;

@Service
public class PlanesServiceImpl implements PlanesService {

	@Autowired
	PlanDAO planDaoImpl;
	@Autowired
	BOPlanesInterface BoPlanImpl;
	
	
	@Transactional
	@Override
	public void agregarPlan(DTOPlan dtoPlan) {
		Planes modelPlan=BoPlanImpl.DtoPlanToModelPlan(dtoPlan);
		planDaoImpl.insertarPlanEnDB(modelPlan);
	}

	@Transactional
	@Override
	public List<DTOPlan> listarPlanes() {
		return BoPlanImpl.listModelPlanToListDtoPlan(planDaoImpl.listaPlanes());
	}

	@Transactional
	@Override
	public void eliminarPlan(int id) {
		planDaoImpl.eliminarPlanEnDB(id);
	}

	@Transactional
	@Override
	public void actualizarPlan(int id, DTOPlan dtoPlan) {
		Planes modelPlan=BoPlanImpl.DtoPlanToModelPlan(dtoPlan);
		planDaoImpl.actualizarPlanEnDB(id, modelPlan);

	}

	@Transactional
	@Override
	public DTOPlan findPlanConId(int id) {
		return BoPlanImpl.modelPlanToDtoPlan(planDaoImpl.findPlanPorId(id));
	}

}
