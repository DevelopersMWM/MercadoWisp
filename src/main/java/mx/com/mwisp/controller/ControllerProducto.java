package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.com.mwisp.model.Productos;
import mx.com.mwisp.service.ProductoService;

@Controller
@ManagedBean
@RequestScoped
public class ControllerProducto {

	@Autowired
	ProductoService productoServiceImpl;
	
	
	private String nombre;
	private float precio;
	private String descripcion;
	private String garantia;
	
	//variable que pasa el precio
	private String enviarPrecio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGarantia() {
		return garantia;
	}
	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	public String getEnviarPrecio() {
		return enviarPrecio;
	}
	public void setEnviarPrecio(String enviarPrecio) {
		this.enviarPrecio = enviarPrecio;
	}
	
	
	//este metodo retorna una lista de productos. y es llamado desde la vista ListProduct.xhtml a través del MB ComtrollerProduct
	public List<Productos> listarProductos(){
		return productoServiceImpl.listarProductos();
		
	}
	
	public String agregarProducto(ControllerProducto producto) {
		productoServiceImpl.insertarProducto(new Productos(producto.getNombre(),producto.getPrecio(), producto.getDescripcion(), producto.getGarantia()));
		return "vistaProductos.xhtml?faces-redirect=true";
	}
	
	public void eliminarProducto(int id) {
		productoServiceImpl.eliminarProducto(id);
	}
	public String pagar() {
		enviarPrecio=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPrecio");
		return "card";
	}
}
