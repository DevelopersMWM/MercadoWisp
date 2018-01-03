package mx.com.mwm.dto;

import java.io.Serializable;

public class DTOPersona implements Serializable{
	private static final long serialVersionUID = -76192321438766969L;//si lago sale mal es aqui :D
	
	private int idPersona;
	private String nombrePersona;
	private String apPaterno;
	private String apMaterno;
	private String telPersona;
	
	public DTOPersona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTOPersona(String nombrePersona, String apPaterno, String apMaterno, String telPersona) {
		super();
		this.nombrePersona = nombrePersona;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telPersona = telPersona;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getTelPersona() {
		return telPersona;
	}

	public void setTelPersona(String telPersona) {
		this.telPersona = telPersona;
	}
}
