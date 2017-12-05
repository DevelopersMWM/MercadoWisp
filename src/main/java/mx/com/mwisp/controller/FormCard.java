package mx.com.mwisp.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import mx.com.mwisp.openpay.CargoTarjeta;



@ManagedBean
@RequestScoped

public class FormCard {
	private final static Logger log=Logger.getLogger(FormCard.class); 
	
	
	private String token;
	private String titularCard;
	private String numberCard;
	private String mes;
	private String anio;
	private String codigoCard;
	
	public FormCard() {
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTitularCard() {
		return titularCard;
	}

	public void setTitularCard(String titularCard) {
		this.titularCard = titularCard;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getCodigoCard() {
		return codigoCard;
	}

	public void setCodigoCard(String codigoCard) {
		this.codigoCard = codigoCard;
	}
	
	public void imprimir() {
		log.info("Entrando al metodo"+ " imprimir()===cargo por tarjeta");
		log.info("token generado"+token+"===========================");
		log.info("nombre del titular"+titularCard);
	
		CargoTarjeta cargoT=new CargoTarjeta();
		cargoT.cargoT(token, "card", 100, "MXN", "Compra TP-link", "1rvGhOGaFgPwNbrtefA4IwPZbMRjsQpe", "Jorge", "Damian", "9581318869", "coco_dava@hotmail.com");
		
	
	}
	

}
