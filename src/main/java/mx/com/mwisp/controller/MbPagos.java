package mx.com.mwisp.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import mx.com.mwisp.openpay.CargoBanco;
import mx.com.mwisp.openpay.CargoTienda;
import mx.com.mwisp.openpay.ClienteOpenpay;
import mx.com.mwisp.openpay.ObjPeticion;
import mx.com.mwisp.openpay.RespuestaPeticion;

@ManagedBean
@ViewScoped
public class MbPagos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonasForm personaForm = new PersonasForm();

	private boolean skip;

	public PersonasForm getPersonaForm() {
		return personaForm;
	}

	public void setPersonaForm(PersonasForm personaForm) {
		this.personaForm = personaForm;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
	
	public void pagar()  throws IOException{
		ClienteOpenpay clienteOpenpay=new ClienteOpenpay(personaForm.getName(), personaForm.getApellidoPaterno(), personaForm.getNumeroTelefono(), "Openpay@gmail.com");
		
		System.out.println(personaForm.getFormaDePago());
		
		if (personaForm.getFormaDePago().equals("Pago en tiendas")) {
			System.out.println("Enviando Pago a tienda");
			ObjPeticion objPeticion=new ObjPeticion("store", 200, "MXN", "mac pro", clienteOpenpay);
			CargoTienda cargoTienda=new CargoTienda();
			RespuestaPeticion respuestaPeticion=cargoTienda.cargoStore(objPeticion);
			System.out.println(respuestaPeticion.getPayment_method().getReference());
			String urlPdf;
			urlPdf="https://sandbox-dashboard.openpay.mx/paynet-pdf/mexcviwsqt2snzeylcy5"+"/"+respuestaPeticion.getPayment_method().getReference();
			System.out.println(urlPdf);
			 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			    externalContext.redirect(urlPdf);
			
			
	}
		else {
			System.out.println("Enviando Pago a Banco");
			ObjPeticion objPeticion=new ObjPeticion("bank_account", 200, "MXN", "mac pro", clienteOpenpay);
			CargoBanco cargoBanco=new CargoBanco();
			RespuestaPeticion respuestaPeticion=cargoBanco.cargoB(objPeticion);
			System.out.println(respuestaPeticion.getId());
			String urlPdfBanco="\r\n" +"https://sandbox-dashboard.openpay.mx/spei-pdf/mexcviwsqt2snzeylcy5/"+respuestaPeticion.getId();
			System.out.println(urlPdfBanco);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    externalContext.redirect(urlPdfBanco);
						
		}
	
	}

}
