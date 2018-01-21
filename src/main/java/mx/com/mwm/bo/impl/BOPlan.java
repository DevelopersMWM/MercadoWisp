package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Planes;
import mx.com.mwm.bo.BOPlanesInterface;
import mx.com.mwm.dto.DTOPlan;

@Component("boPlan")
@Scope("prototype")
public class BOPlan implements BOPlanesInterface {

	@Override
	public DTOPlan modelPlanToDtoPlan(Planes modelplan) {
		DTOPlan dtoPlan=new DTOPlan();
		dtoPlan.setIdPlan(modelplan.getIdPlan());
		dtoPlan.setNombrePlan(modelplan.getNombre());
		dtoPlan.setBajadaPlan(modelplan.getBajada());
		dtoPlan.setSubidaPlan(modelplan.getSubida());
		dtoPlan.setCostoPlan(modelplan.getPrecio());
		dtoPlan.setFechaCreacion(modelplan.getFechaCreacion());
		return dtoPlan;
	}

	@Override
	public List<DTOPlan> listModelPlanToListDtoPlan(List<Planes> listModelPlan) {
		List<DTOPlan> listDtoPlan=null;
		if(listModelPlan!=null) {
			listDtoPlan=new ArrayList<DTOPlan>();
			for(Planes modelPlanes:listModelPlan) {
				listDtoPlan.add(this.modelPlanToDtoPlan(modelPlanes));
			}
		}
		return listDtoPlan;
	}

	@Override
	public Planes DtoPlanToModelPlan(DTOPlan dtoPlan) {
		Planes modelPlanes=new Planes();
		modelPlanes.setIdPlan(dtoPlan.getIdPlan());
		modelPlanes.setNombre(dtoPlan.getNombrePlan());
		modelPlanes.setBajada(dtoPlan.getBajadaPlan());
		modelPlanes.setSubida(dtoPlan.getSubidaPlan());
		modelPlanes.setPrecio(dtoPlan.getCostoPlan());
		modelPlanes.setFechaCreacion(dtoPlan.getFechaCreacion());
		return modelPlanes;
	}

	@Override
	public List<Planes> listDtoPlanToListDtoPlan(List<DTOPlan> listDtoPlan) {
		List<Planes> modelListPlanes=null;
		if(listDtoPlan!=null) {
			modelListPlanes=new ArrayList<Planes>();
			for(DTOPlan dtoPlan:listDtoPlan) {
				modelListPlanes.add(this.DtoPlanToModelPlan(dtoPlan));
			}
		}
		return modelListPlanes;
	}

}
