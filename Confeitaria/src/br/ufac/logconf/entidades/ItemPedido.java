package br.ufac.logconf.entidades;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name="itempedido")
@NamedQueries({
@NamedQuery(name="ItemPedido.todos", query="SELECT i FROM ItemPedido i"),
@NamedQuery(name="ItemPedido.todosPorID", query="SELECT i FROM ItemPedido i WHERE i.id LIKE :id ORDER BY i.id")
})
public class ItemPedido {

	@Id
	private int id;
	@Column(nullable=false, length=50)
	private int quantidade;
	/*	@Column(nullable=false, length=10)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataEntrada;
	@Column(nullable=false, length=10)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataSaida;*/
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="material_fk")
	private Material material;	

	@ManyToOne
	@JoinColumn(name = "pedido_fk")
	private Pedido pedido;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public String toString() {
		return String.format("Material [id=%d, nome=\"%s\", descricao=\"%s\", quantidade=%d, dataEntrada=\"%s\", dataSaida=\"%s\", categoria=\"%s\"]", id, quantidade);
	}
	
}
