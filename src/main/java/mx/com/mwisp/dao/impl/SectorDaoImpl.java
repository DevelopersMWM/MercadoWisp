package mx.com.mwisp.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.com.mwisp.controller.SectorController;
import mx.com.mwisp.dao.SectorDao;
import mx.com.mwisp.model.Sector;
import mx.com.mwisp.model.Torre;
import mx.com.mwm.dto.DTOSectores;
import mx.com.mwm.dto.helper.FormSectores;

@Repository
public class SectorDaoImpl implements SectorDao {

	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sector> listaSectores() {
		Query query=em.createQuery("select r from Sector r");
		List<Sector> sectoresList=(List<Sector>) query.getResultList();
		return sectoresList;
	}

	@Override
	public void insertarSectorEnDB(Sector sector) {
		//SectorController sectorController=new SectorController();
//		int idTorre=Integer.parseInt(sectorController.formSectorImpl.getTorre());
		//System.out.println("====>>>IdTorre="+sectorController.formSectorImpl.getTorre());
//		FormSectores formSector=new FormSectores();
//		int idTorre=Integer.parseInt(formSector.getTorre());
//		System.out.println("----"+idTorre);
		//Torre torre=em.find(Torre.class, 3); eliminas estas lineas y solo agregas el sector
		//sector.setTorre(torre);
		em.persist(sector);
	}

	@Override
	public void eliminarSectorEnDB(int id) {
		Sector sector=em.find(Sector.class, id);
		em.remove(sector);
	}

	@Override
	public void actualizarSectorEnDB(int id, Sector sector) {
		sector.setIdSector(id);
		em.merge(sector);
	}

	@Override
	public Sector encontrarSectorPorId(int id) {
		Sector sector=em.find(Sector.class, id);
		return sector;
	}

}
