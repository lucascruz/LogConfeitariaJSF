package br.ufac.logconf.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "itempedido")
@NamedQueries({ @NamedQuery(name = "ItemPedido.todos", query = "SELECT i FROM ItemPedido i"),
		@NamedQuery(name = "ItemPedido.todosPorID", query = "SELECT i FROM ItemPedido i WHERE i.id LIKE :id ORDER BY i.id") })
public class ItemPedido {

	@Id
	private int id;
	@Column(nullable = false, length = 50)
	private int quantidade;

	@OneToMany(mappedBy = "itempedidos", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Material> material = new ArrayList<Material>();

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "pedido_fk")
	private Pedido pedido;
	
	public ItemPedido() {

	}

	
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



	public List<Material> getMaterial() {
		return material;
	}



	public void setMaterial(Material m) {
		material.add(m);
	}


	public Pedido getPedido() {
		return this.pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido= pedido;
	}



	@Override
	public String toString() {
		return String.format("Material [Nome=%s, quantidade=%d]", material.toString(), quantidade);
	}


}
