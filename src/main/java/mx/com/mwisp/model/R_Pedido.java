package mx.com.mwisp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="r_pedido")
public class R_Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Pedido")
	private int idPedido;
	
	
	@ManyToOne
	@JoinColumn(name="Fk_Proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="Fk_Producto")
	private Productos producto;
	
	public R_Pedido() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "R_Pedido [idPedido=" + idPedido + ", proveedor=" + proveedor + ", producto=" + producto + "]";
	}
}

