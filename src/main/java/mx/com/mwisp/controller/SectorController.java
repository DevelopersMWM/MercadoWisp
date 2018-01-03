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
	
	FormSectores formSectorImpl;
	
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

	public FormSectores getFormSectorImpl() {
		return formSectorImpl;
	}

	public void setFormSectorImpl(FormSectores formSectorImpl) {
		this.formSectorImpl = formSectorImpl;
	}
}
