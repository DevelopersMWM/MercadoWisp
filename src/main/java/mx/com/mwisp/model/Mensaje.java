package mx.com.mwisp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_mensaje")
public class Mensaje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Mensaje")
	private int idMensaje;
	
	@Column(name="Nombre_Mesaje")
	private String nombreMensaje;
	
	@Column(name="Cuerpo_Mensaje")
	private String cuerpoMensaje;

	public Mensaje() {
		super();
	}

	public Mensaje(String nombreMensaje, String cuerpoMensaje) {
		super();
		this.nombreMensaje = nombreMensaje;
		this.cuerpoMensaje = cuerpoMensaje;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getNombreMensaje() {
		return nombreMensaje;
	}

	public void setNombreMensaje(String nombreMensaje) {
		this.nombreMensaje = nombreMensaje;
	}

	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}

	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}
	
	@Override
	public String toString() {
		return "Mensaje [idMensaje=" + idMensaje + ", nombreMensaje=" + nombreMensaje + ", cuerpoMensaje="
				+ cuerpoMensaje + "]";
	}
}
