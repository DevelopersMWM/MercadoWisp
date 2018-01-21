package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTODispositivos;

public class FormDispositivos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5337716819271633467L;

	private String nombreDisp;
	private String modeloDisp;
	private String obtenerId;
	private List<DTODispositivos> listaDispositivos;
	
	public String getNombreDisp() {
		return nombreDisp;
	}
	public void setNombreDisp(String nombreDisp) {
		this.nombreDisp = nombreDisp;
	}
	public String getModeloDisp() {
		return modeloDisp;
	}
	public void setModeloDisp(String modeloDisp) {
		this.modeloDisp = modeloDisp;
	}
	public String getObtenerId() {
		return obtenerId;
	}
	public void setObtenerId(String obtenerId) {
		this.obtenerId = obtenerId;
	}
	public List<DTODispositivos> getListaDispositivos() {
		return listaDispositivos;
	}
	public void setListaDispositivos(List<DTODispositivos> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}
}
