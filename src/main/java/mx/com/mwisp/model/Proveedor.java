package mx.com.mwisp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Proveedor")
	private int IdProveedor;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Telefono")
	private String telefono;
	
	@Column(name="Rfc")
	private String rfc;
	
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public Proveedor(String nombre, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.rfc = direccion;
	}

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return rfc;
	}

	public void setDireccion(String direccion) {
		this.rfc = direccion;
	}

	@Override
	public String toString() {
		return "Proveedor [IdProveedor=" + IdProveedor + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + rfc + "]";
	}
	
	
	
	
	
	

}
