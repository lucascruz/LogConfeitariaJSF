package br.ufac.logconf.entidades;

import javax.persistence.*;

@Entity
@Table(name="categorias")
@NamedQueries({
@NamedQuery(name="Categoria.todos", query="SELECT c FROM Categoria c"),
@NamedQuery(name="Categoria.todosPorNome", query="SELECT c FROM Categoria c ORDER BY c.nome"),
@NamedQuery(name="Categoria.todosPorID", query="SELECT c FROM Categoria c WHERE c.id LIKE :id ORDER BY c.id")
})
public class Categoria {

	@Id
	private int id;
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=false, length=100)
	private String descricao;
	
	
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
	public String toString() {
		return String.format("Categoria [id=%d, nome=\"%s\", descricao=\"%s\"]", id, nome, descricao);
	}
	
}
