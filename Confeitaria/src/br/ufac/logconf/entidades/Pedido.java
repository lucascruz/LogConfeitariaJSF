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
	
	
	//private Fornecedor fornecedor;
	

	@OneToMany
	@JoinColumn(name = "pedido_pk")
	private List<ItemPedido> items = new ArrayList<ItemPedido>();

	@OneToMany
	@JoinColumn(name = "fornecedor_pk")
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	@ManyToOne
	@JoinColumn(name = "funcionario_pk")
	private Funcionario funcionario;
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
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
		return items;
	}

	public void setItemspedidos(List<ItemPedido> itemspedidos) {
		this.items = itemspedidos;
	}

	public Funcionario getFuncionarios_Pedido() {
		return funcionario;
	}

	public void setFuncionarios_Pedido(Funcionario funcionarios_Pedido) {
		this.funcionario = funcionarios_Pedido;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void addItemPedido(ItemPedido ip1) {
		this.items.add(ip1);
	}

	public void dellItemPedido(ItemPedido ip2) {
		this.items.remove(ip2);
	}

	public void addFornecedor(Fornecedor f1) {
		this.fornecedores.add(f1);
	}

	public void dellFornecedor(Fornecedor f2) {
		this.fornecedores.remove(f2);
	}
	
	
	

/*	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}*/

	@Override
	public String toString() {
		return String.format(
				"Categoria [id=%d, status=\"%s\", numero total de itens no pedido=%d]", id,
				status, items.size() );
	}

}
