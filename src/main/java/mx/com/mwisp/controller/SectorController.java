package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.service.SectoresService;
import mx.com.mwm.dto.DTOSectores;
import mx.com.mwm.dto.helper.FormSectores;

@Controller
@ManagedBean
@RequestScoped
public class SectorController {
	
	@Autowired
	SectoresService sectorServiceImpl;
	
	public FormSectores formSectorImpl;
	
	public SectorController() {
		try {
			formSectorImpl=new FormSectores();
		}catch(Exception e) {
			System.out.println("::Error:"+e.getMessage());
		}
	}

	public List<DTOSectores> listarSectores(){
		
		formSectorImpl.setSectoresList(sectorServiceImpl.listaDeSectores());
		return formSectorImpl.getSectoresList();
	}
	
	public String agregarSector() {
		sectorServiceImpl.insertarSector(new DTOSectores(formSectorImpl.getNombre(), Integer.parseInt(formSectorImpl.getIdTorre())));//recibes el id de la torre y el nobre del sector
		//System.out.println("idTorre: "+formSectorImpl.getTorre());
		return "ListaSectores.xhtml?faces-redirect=true";
	}

	public FormSectores getFormSectorImpl() {
		return formSectorImpl;
	}

	public void setFormSectorImpl(FormSectores formSectorImpl) {
		this.formSectorImpl = formSectorImpl;
	}
}
