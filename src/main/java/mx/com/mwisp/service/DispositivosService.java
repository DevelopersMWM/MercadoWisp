package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTODispositivos;

public interface DispositivosService {
	public void eliminarDispositivo(int id);
	public List<DTODispositivos> listarDispositivos();
	public DTODispositivos findDispositivoPorId(int id);
	public void insertarDispositivo(DTODispositivos dtoDispositivo);
	public void updateDispositivoPorId(int id,DTODispositivos dtoDispositivo);
}
