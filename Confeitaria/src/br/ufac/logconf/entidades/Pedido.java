package br.ufac.logconf.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name="pedidos")
@NamedQueries({
@NamedQuery(name="Pedido.todos", query="SELECT p FROM Pedido p"),
@NamedQuery(name="Pedido.todosPorNome", query="SELECT p FROM Pedido p ORDER BY p.id"),
@NamedQuery(name="Pedido.todosPorID", query="SELECT p FROM Pedido p WHERE p.id LIKE :id ORDER BY p.id")
})

public class Pedido {

	@Id
	private int id;
	@Column(nullable=false, length=50)
	private String status;
	@Column(name = "materiais", nullable=false)
	//@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Material> materiais = new ArrayList<>();
	
	
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
	public List<Material> getMateriais() {
		return materiais;
	}
	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	
	public void addMaterial(Material m) {
		m.setPedido(this);
		materiais.add(m);
	}
	public void delMaterial(Material m) {
		m.setPedido(null);
		materiais.remove(m);
	}
	
	public String toString() {
		return String.format("Categoria [id=%d, status=\"%s\", materiais=%d]", id, status, materiais.size());
	}
	
}
