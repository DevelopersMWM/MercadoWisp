package mx.com.mwisp.dao;

import java.util.List;

import mx.com.mwisp.model.Dispositivos;

public interface DispositivosDAO {
	public List<Dispositivos> dispositivosList();
	public void guardarDispositivoEnBD(Dispositivos device);
	public void eliminarDispositivoEnBD(int id);
	public void actualizarDispositivoEnBD(int id,Dispositivos device);
	public Dispositivos encontrarDispositivoEnBDPorId(int id);
	
}
