package mx.com.mwisp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_torres")
public class Torre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Torre")
	private int idTorre;
	
	@Column(name="Nombre_Torre")
	private String nombre;

	public Torre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Torre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdTorre() {
		return idTorre;
	}

	public void setIdTorre(int idTorre) {
		this.idTorre = idTorre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Torre [idTorre=" + idTorre + ", nombre=" + nombre + "]";
	}
}
