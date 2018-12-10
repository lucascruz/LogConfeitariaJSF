package br.ufac.logconf.entidades;

import javax.persistence.*;

@Entity
@Table(name = "materiais")
@NamedQueries({ @NamedQuery(name = "Material.todos", query = "SELECT m FROM Material m"),
		@NamedQuery(name = "Material.todosPorNome", query = "SELECT m FROM Material m ORDER BY m.nome"),
		@NamedQuery(name = "Material.todosPorID", query = "SELECT m FROM Material m WHERE m.id LIKE :id ORDER BY m.id") })
public class Material {

	@Id
	private int id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 100)
	private String descricao;
	@Column(nullable = false, length = 10)
	private String dataValidade;

	@ManyToOne
	@JoinColumn(name = "categoria_fk")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "itempedido_fk")
	private ItemPedido itempedidos;
	
	
	public Material() {

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public ItemPedido getItempedidos() {
		return itempedidos;
	}


	public void setItempedidos(ItemPedido itempedidos) {
		this.itempedidos = itempedidos;
	}


	@Override
	public String toString() {
		return String.format("Material [id=%d, nome=\"%s\", descricao=\"%s\", categoria=\"%s\", DataValidade=\"%s\"]",
				id, nome, descricao, categoria, dataValidade);
	}

}
