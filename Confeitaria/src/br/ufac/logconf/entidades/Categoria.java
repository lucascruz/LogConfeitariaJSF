package br.ufac.logconf.entidades;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "categorias")
@NamedQueries({ @NamedQuery(name = "Categoria.todos", query = "SELECT c FROM Categoria c"),
		@NamedQuery(name = "Categoria.todosPorNome", query = "SELECT c FROM Categoria c ORDER BY c.nome"),
		@NamedQuery(name = "Categoria.todosPorID", query = "SELECT c FROM Categoria c WHERE c.id LIKE :id ORDER BY c.id") })
public class Categoria {

	@Id
	private int id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 100)
	private String descricao;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="fornecedor_pk", nullable=false)
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy="categoria", orphanRemoval=true)
	@Cascade(value= {org.hibernate.annotations.CascadeType.ALL})
	private List <Material> materiais;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fornecedor getFornecedores() {
		return fornecedor;
	}

	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedor = fornecedores;
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	public String toString() {
		return String.format("Categoria [id=%d, nome=\"%s\", descricao=\"%s\"]", id, nome, descricao);
	}

}
