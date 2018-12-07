package br.ufac.logconf.entidades;

import java.util.*;

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
	@Column(nullable=false, length=10)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrada;
	@Column(nullable=false, length=10)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaida;
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
	public List <ItemPedido> getMateriais() {
		return itemspedidos;
	}
	public void setPedidos(List<ItemPedido> itempedido) {
		this.itemspedidos = itempedido;
	}
	
	public void addItemPedido(ItemPedido ip) {
		itemspedidos.add(ip);
	}
	public void delMaterial(ItemPedido ip) {
		itemspedidos.remove(ip);
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada() {
		this.dataEntrada = Calendar.getInstance();
	}
	@Temporal(TemporalType.DATE)
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public List<ItemPedido> getItemspedidos() {
		return itemspedidos;
	}
	public void setItemspedidos(List<ItemPedido> itemspedidos) {
		this.itemspedidos = itemspedidos;
	}
	public String toString() {
		return String.format("Categoria [id=%d, status=\"%s\", materiais=%d]", id, status, itemspedidos.size());
	}
	
}
