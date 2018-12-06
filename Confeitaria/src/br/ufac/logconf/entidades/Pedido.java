package br.ufac.logconf.entidades;


import java.util.Collection;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name="pedidos")
@NamedQueries({
@NamedQuery(name="Pedido.todos", query="SELECT p FROM Pedido p"),
@NamedQuery(name="Pedido.todosPorID", query="SELECT p FROM Pedido p WHERE p.id LIKE :id ORDER BY p.id")
})

public class Pedido {

	@Id
	private int id;
	@Column(nullable=false, length=50)
	private String status;

	@OneToMany(mappedBy="pedido",cascade=CascadeType.ALL)
	private List<ItemPedido> itemspedidos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Collection<ItemPedido> getMateriais() {
		return itemspedidos;
	}
	public void setPedidos(List<ItemPedido> itempedido) {
		this.itemspedidos = itempedido;
	}
	
	public void addItemPedido(ItemPedido ip) {
		ip.setPedido(this);
		itemspedidos.add(ip);
	}
	public void delMaterial(ItemPedido ip) {
		ip.setPedido(null);
		itemspedidos.remove(ip);
	}
	
	public String toString() {
		return String.format("Categoria [id=%d, status=\"%s\", materiais=%d]", id, status, itemspedidos.size());
	}
	
}
