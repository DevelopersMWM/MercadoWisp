package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Sector;

public interface SectorDao {
	public List<Sector> listaSectores();
	public void insertarSectorEnDB(Sector sector);
	public void eliminarSectorEnDB(int id);
	public void actualizarSectorEnDB(int id,Sector sector);
	public Sector encontrarSectorPorId(int id);
}
