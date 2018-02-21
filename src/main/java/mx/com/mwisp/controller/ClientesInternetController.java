package mx.com.mwisp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ClienteInternetService;
import mx.com.mwm.dto.DTOClienteInternet;
import mx.com.mwm.dto.helper.FormClienteInternet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@ManagedBean
@RequestScoped
public class ClientesInternetController {

	@Autowired
	ClienteInternetService clienteServiceImpl;

	FormClienteInternet formCliente;

	public ClientesInternetController() {
		try {
			formCliente = new FormClienteInternet();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<DTOClienteInternet> listaClientesSuspendidos(){
		List<DTOClienteInternet> listClientesActivos=null;
		if(clienteServiceImpl.listaClientes()!=null) {
			listClientesActivos=new ArrayList<DTOClienteInternet>();
			for(DTOClienteInternet clienteActivo:clienteServiceImpl.listaClientes()) {
				if(clienteActivo.getEstatus()==false) {
					listClientesActivos.add(clienteActivo);
				}
			}
			formCliente.setListClientes(listClientesActivos);
		}
		return formCliente.getListClientes();
	}
	public List<DTOClienteInternet> listaClientesActivos(){
		List<DTOClienteInternet> listClientesActivos=null;
		if(clienteServiceImpl.listaClientes()!=null) {
			listClientesActivos=new ArrayList<DTOClienteInternet>();
			for(DTOClienteInternet clienteActivo:clienteServiceImpl.listaClientes()) {
				if(clienteActivo.getEstatus()==true) {
					listClientesActivos.add(clienteActivo);
				}
			}
			formCliente.setListClientes(listClientesActivos);
		}
		return formCliente.getListClientes();
	}
	
	public String agregarCliente() {
		clienteServiceImpl.insertarCliente(new DTOClienteInternet(formCliente.getIpCliente(),formCliente.getFechaInstalacion(),formCliente.getPrimerPago(), formCliente.getEmail(),formCliente.getDiaCobro(), formCliente.getUbicacionCliente(), Integer.parseInt(formCliente.getIdSector()), Integer.parseInt(formCliente.getIdEquipo()), Integer.parseInt(formCliente.getIdplan()), Integer.parseInt(formCliente.getIdRouter())));
		return "ListaClientesInternet.xhtml?faces-redirect=true";
	}

	public void exportarAPDF() throws JRException, IOException {
		File jasper= new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasper.getPath(), null,new JRBeanCollectionDataSource(this.listaClientesActivos()));
		
		HttpServletResponse response= (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf ");
		
		ServletOutputStream stream=response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public FormClienteInternet getFormCliente() {
		return formCliente;
	}

	public void setFormCliente(FormClienteInternet formCliente) {
		this.formCliente = formCliente;
	}

}
