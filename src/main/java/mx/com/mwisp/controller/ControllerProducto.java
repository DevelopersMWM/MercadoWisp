package mx.com.mwisp.controller;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mx.com.mwisp.service.ProductoService;
import mx.com.mwm.dto.DTOProductos;
import mx.com.mwm.dto.helper.FormProductos;

@Controller
@ManagedBean
@RequestScoped
public class ControllerProducto {

	@Autowired
	ProductoService productoServiceImpl;
	
	private static final Logger log = LoggerFactory.getLogger(ControllerProducto.class);
	
	FormProductos formProduct;
	
	public ControllerProducto(){
		try{
			formProduct = new FormProductos();
		}catch(Exception e){
			log.error(":::Error en el método inicial del ControllerProducto::: ",e);
		}
	}
	
	//este metodo retorna una lista de productos. y es llamado desde la vista ListProduct.xhtml a trav�s del MB ComtrollerProduct
	public List<DTOProductos> listarProductos(){
		formProduct.setListProductos(productoServiceImpl.listarProductos());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg1').show();");
		return formProduct.getListProductos();
	}
	
	public String agregarProducto() {
		productoServiceImpl.insertarProducto(new DTOProductos(formProduct.getNombre(),formProduct.getPrecio(), formProduct.getDescripcion(), formProduct.getGarantia()));
		return "vistaProductos.xhtml?faces-redirect=true";
	}
	
	public void eliminarProducto(int id) {
		productoServiceImpl.eliminarProducto(id);
	}
	public String pagar() {
		formProduct.setEnviarPrecio(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPrecio"));
		return "card.xhtml?faces-redirect=true";
	}
	public String editarProducto() {
		formProduct.setObtenerId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectIdProduct"));
		 int id=Integer.parseInt(formProduct.getObtenerId());
		 DTOProductos dtoProducto=new DTOProductos();
		 dtoProducto=productoServiceImpl.encontrarProductoPorId(id);
		 formProduct.setNombre(dtoProducto.getNombreProducto());
		 formProduct.setPrecio(dtoProducto.getPrecio());
		 formProduct.setDescripcion(dtoProducto.getDescripcionProducto());
		 formProduct.setGarantia(dtoProducto.getTiempoGarantia());
		 
		return "editarProducto";
	}
	public String actualizarProducto() {
		int id=Integer.parseInt(formProduct.getObtenerId());
		productoServiceImpl.ActualizarProducto(id,new DTOProductos(formProduct.getNombre(), formProduct.getPrecio(), formProduct.getDescripcion(), formProduct.getGarantia()));
		return "vistaProductos.xhtml?faces-redirect=true";
	}

	public FormProductos getFormProduct() {
		return formProduct;
	}

	public void setFormProduct(FormProductos formProduct) {
		this.formProduct = formProduct;
	}
	
}
