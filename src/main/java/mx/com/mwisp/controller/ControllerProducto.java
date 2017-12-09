package mx.com.mwisp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	private String categoria;
	private float precio;
	private String descripcion;
	private String garantia;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	
	//este metodo retorna una lista de productos. y es llamado desde la vista ListProduct.xhtml a través del MB ComtrollerProduct
	public List<Productos> listarProductos(){
		return productoServiceImpl.listarProductos();
		
	}
}
