package mx.com.mwm.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.mwisp.model.Direccion;
import mx.com.mwisp.model.Persona;
import mx.com.mwm.bo.BODireccionInterface;
import mx.com.mwm.dto.DTODireccion;

@Component("boDireccion")
@Scope("prototype")
public class BODireccion implements BODireccionInterface {

	@Override
	public DTODireccion modeloDireccionToDtoDireccion(Direccion modelDireccion) {
		DTODireccion dtoDireccion=new DTODireccion();
		dtoDireccion.setIdDireccion(modelDireccion.getIdDireccion());
		dtoDireccion.setCodigoPostal(modelDireccion.getCodigoPostal());
		dtoDireccion.setNumeroExt(modelDireccion.getNumeroExterior());
		dtoDireccion.setCalle(modelDireccion.getCalle());
		dtoDireccion.setNumeroInt(modelDireccion.getNumeroInterior());
		dtoDireccion.setEstado(modelDireccion.getEstado());
		dtoDireccion.setMunicipio(modelDireccion.getMunicipio());
		dtoDireccion.setColonia(modelDireccion.getColonia());
		//dtoDireccion.setIdPersona(modelDireccion.getPersona().getId_Persona());
		dtoDireccion.setPersonaNombre(modelDireccion.getPersona().getNombre());
		return dtoDireccion;
	}

	@Override
	public List<DTODireccion> listModelDireccionToListDtoDireccion(List<Direccion> listModelDireccion) {
		List<DTODireccion> DTOListDir=null;
		if(listModelDireccion!=null) {
			DTOListDir=new ArrayList<DTODireccion>();
					for(Direccion modelDireccion:listModelDireccion) {
						DTOListDir.add(this.modeloDireccionToDtoDireccion(modelDireccion));
					}
		}
		return DTOListDir;
	}

	@Override
	public Direccion dtoDireccionToModelDireccion(DTODireccion dtoDireccion) {
		Direccion modelDireccion= new Direccion();
		modelDireccion.setIdDireccion(dtoDireccion.getIdDireccion());
		modelDireccion.setCodigoPostal(dtoDireccion.getCodigoPostal());
		modelDireccion.setCalle(dtoDireccion.getCalle());
		modelDireccion.setNumeroExterior(dtoDireccion.getNumeroExt());
		modelDireccion.setNumeroInterior(dtoDireccion.getNumeroInt());
		modelDireccion.setEstado(dtoDireccion.getEstado());
		modelDireccion.setColonia(dtoDireccion.getColonia());
		modelDireccion.setMunicipio(dtoDireccion.getMunicipio());
		Persona cliente=new Persona();
		cliente.setId_Persona(dtoDireccion.getIdPersona());
		modelDireccion.setPersona(cliente);
		return modelDireccion;
	}

	@Override
	public List<Direccion> listDtoDirecccionToListModelDireccion(List<DTODireccion> listDtoDireccion) {
		List<Direccion> modelListDir=null;
		if(listDtoDireccion!=null) {
			modelListDir=new ArrayList<Direccion>();
			for(DTODireccion dtoDireccion:listDtoDireccion) {
				modelListDir.add(this.dtoDireccionToModelDireccion(dtoDireccion));
			}
		}
		return modelListDir;
	}

}
