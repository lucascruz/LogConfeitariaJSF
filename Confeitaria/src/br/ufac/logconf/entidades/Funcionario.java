package br.ufac.logconf.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "funcionarios")
@NamedQueries({ @NamedQuery(name = "Funcionario.todos", query = "SELECT u FROM Funcionario u"),
		@NamedQuery(name = "Funcionario.todosPorNome", query = "SELECT u FROM Funcionario u ORDER BY u.nome"),
		@NamedQuery(name = "Funcionario.todosPorID", query = "SELECT u FROM Funcionario u WHERE u.id LIKE :id ORDER BY u.id") })
public class Funcionario {

	@Id
	private int id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 50)
	private String cpf;
	@Column(nullable = false, length = 50)
	private String telefone;
	@Column(nullable = false, length = 50)
	private String sexo;
	@Column(nullable = false, length = 50)
	private int idade;
	@Column(nullable = false, length = 50)
	private String endereco;

	@OneToMany(mappedBy = "funcionarios", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	@OneToMany(mappedBy = "funcionarios_Pedido", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public Funcionario() {
		super();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return String.format(
				"Funcionario [id=%d, nome=\"%s\", cpf=\"%s\", telefone=\"%s\", sexo=\"%s\",idade=%d,endereco=\"%s\"]",
				id, nome, cpf, telefone, sexo, idade, endereco);
	}

}