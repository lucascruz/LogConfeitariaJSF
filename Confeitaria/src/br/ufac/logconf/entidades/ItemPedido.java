package br.ufac.logconf.entidades;

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
	@OneToOne (mappedBy="itempedidos")
	@JoinColumn(name="material_fk")
	private Material material;

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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return String.format("Material [Nome=%s, quantidade=%d]", material.toString(), quantidade);
	}

}
