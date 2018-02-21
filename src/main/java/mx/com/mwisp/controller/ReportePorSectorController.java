package mx.com.mwisp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.ReportePorSectorService;
import mx.com.mwm.dto.DTOReportePorSector;
import mx.com.mwm.dto.helper.FormReportePorSector;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@ManagedBean
@RequestScoped
public class ReportePorSectorController {
	
	@Autowired
	ReportePorSectorService reportSectorService;
	
	FormReportePorSector formReportBySector;

	public ReportePorSectorController() {
		try {
			formReportBySector=new FormReportePorSector();
		}catch (Exception e) {
			System.out.println("Error:!! "+e.getMessage());
		}
	}
	
	public List<DTOReportePorSector> reportePorSector(){
		formReportBySector.setListaSectorReport(reportSectorService.listReporteBySector());
		return formReportBySector.getListaSectorReport();
	}
	
	public void reportePorSectorAPDF() throws JRException, IOException {
		Map<String,Object> parameters= new HashMap<String,Object>();
		Date fecha=new Date();
		parameters.put("txtFecha", fecha);
		
		File jasper= new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportPorSector.jasper"));
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasper.getPath(), parameters,new JRBeanCollectionDataSource(this.reportePorSector()));
		
		HttpServletResponse response= (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition", "attachment; filename=ReportePorSector.pdf ");
		
		ServletOutputStream stream=response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		FacesContext.getCurrentInstance().responseComplete();
	}

	public FormReportePorSector getFormReportBySector() {
		return formReportBySector;
	}

	public void setFormReportBySector(FormReportePorSector formReportBySector) {
		this.formReportBySector = formReportBySector;
	}
	

}
