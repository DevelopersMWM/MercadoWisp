package mx.com.mwm.dto.helper;

import java.io.Serializable;
import java.util.List;

import mx.com.mwm.dto.DTORouter;

public class FormRouter implements Serializable{
	private static final long serialVersionUID = 33545984573584464L;//aqui es el problema
	
	private String Nombre;
	private String IpDns;
	private String nombreUsuario;
	private String ubicacion;
	
	private String obtenerId;
	private String obtenerLlave;
	List<DTORouter> listRouter;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getIpDns() {
		return IpDns;
	}
	public void setIpDns(String ipDns) {
		IpDns = ipDns;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getObtenerId() {
		return obtenerId;
	}
	public void setObtenerId(String obtenerId) {
		this.obtenerId = obtenerId;
	}
	public String getObtenerLlave() {
		return obtenerLlave;
	}
	public void setObtenerLlave(String obtenerLlave) {
		this.obtenerLlave = obtenerLlave;
	}
	public List<DTORouter> getListRouter() {
		return listRouter;
	}
	public void setListRouter(List<DTORouter> listRouter) {
		this.listRouter = listRouter;
	}
}
