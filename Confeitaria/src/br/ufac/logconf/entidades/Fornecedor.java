package br.ufac.logconf.entidades;

import javax.persistence.*;

@Entity
@Table(name = "fornecedores")
@NamedQueries({ @NamedQuery(name = "Fornecedor.todos", query = "SELECT f FROM Fornecedor f"),
		@NamedQuery(name = "Fornecedor.todosPorID", query = "SELECT f FROM Fornecedor f WHERE f.id LIKE :id ORDER BY f.id") })
public class Fornecedor {

	@Id
	private int id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 50)
	private String cnpj;
	@Column(nullable = false, length = 50)
	private String endereco;
	@Column(nullable = false, length = 50)
	private String telefone;
	@Column(nullable = false, length = 50)
	private String email;

	@OneToOne
	@JoinColumn(name = "categoria_fk", nullable = true)
	private Categoria categorias;

	@ManyToOne
	@JoinColumn(name = "pedidos_fk", nullable = true)
	private Pedido pedidos;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	public Pedido getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return String.format(
				"Fornecedor [id=%d, nome=\"%s\", cnpj=\"%s\", endereco=\"%s\", telefone=\"%s\", email=\"%s\"]", id,
				nome, cnpj, endereco, telefone, email);
	}

}
