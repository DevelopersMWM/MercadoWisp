package mx.com.mwisp.service;

import java.util.List;

import mx.com.mwm.dto.DTOTorres;

public interface TorreService {
	public void agregarTorre(DTOTorres torre);
	public void eliminarTorre(int id);
	public void actualizarTorre(int id,DTOTorres torre);
	public List<DTOTorres> listaTorres();
	public DTOTorres encontrarTorrePorId(int id);
}
