package mx.com.mwm.bo;

import java.util.List;

import mx.com.mwisp.model.Planes;
import mx.com.mwm.dto.DTOPlan;

public interface BOPlanesInterface {
	public DTOPlan modelPlanToDtoPlan(Planes modelplam);
	public List<DTOPlan> listModelPlanToListDtoPlan(List<Planes> listModelPlan);
	public Planes DtoPlanToModelPlan(DTOPlan dtoPlan);
	public List<Planes> listDtoPlanToListDtoPlan(List<DTOPlan> listDtoPlan);
}
