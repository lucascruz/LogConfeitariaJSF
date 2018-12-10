package br.ufac.logconf.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
@NamedQueries({ @NamedQuery(name = "Pedido.todos", query = "SELECT p FROM Pedido p"),
		@NamedQuery(name = "Pedido.todosPorID", query = "SELECT p FROM Pedido p WHERE p.id LIKE :id ORDER BY p.id") })

public class Pedido {

	@Id
	private int id;
	@Column(nullable = false, length = 50)
	private String status;
	@Column(nullable = false, length = 10)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrada;
	@Column(nullable = false, length = 10)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataSaida;

	// @OneToMany(mappedBy = "pedido", orphanRemoval = true)
	@OneToMany(mappedBy = "pedido", orphanRemoval = true)
	private List<ItemPedido> itemspedidos = new ArrayList<ItemPedido>();

	@Column(nullable = false, length = 100)
	private int quantidadePedir;

	@ManyToOne
	@JoinColumn(name = "funcionario_pk")
	private Funcionario funcionarios_Pedido;

	@OneToMany(mappedBy = "pedidos", orphanRemoval = true)
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	public Pedido() {

	}

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

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	@Temporal(TemporalType.DATE)
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	@Temporal(TemporalType.DATE)
	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public List<ItemPedido> getItemspedidos() {
		return itemspedidos;
	}

	public void setItemspedidos(List<ItemPedido> itemspedidos) {
		this.itemspedidos = itemspedidos;
	}

	public int getQuantidadePedir() {
		return quantidadePedir;
	}

	public void setQuantidadePedir(int quantidadePedir) {
		this.quantidadePedir = quantidadePedir;
	}

	public Funcionario getFuncionarios_Pedido() {
		return funcionarios_Pedido;
	}

	public void setFuncionarios_Pedido(Funcionario funcionarios_Pedido) {
		this.funcionarios_Pedido = funcionarios_Pedido;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public String toString() {
		return String.format(
				"Categoria [id=%d, status=\"%s\", numero total de itens=%d, quantidade de materiais a pedir=%d]", id,
				status, itemspedidos.size(), quantidadePedir);
	}

	@Transient
	public void addItemPedido(ItemPedido ip1) {
		itemspedidos.add(ip1);
	}

	@Transient
	public void dellItemPedido(ItemPedido ip2) {
		itemspedidos.remove(ip2);
	}

}
