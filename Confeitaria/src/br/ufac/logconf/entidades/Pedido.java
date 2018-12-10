package br.ufac.logconf.entidades;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

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

	@OneToMany(mappedBy = "pedido", orphanRemoval = true)
	@Cascade(value= {org.hibernate.annotations.CascadeType.ALL})
	private List <ItemPedido> itemspedidos = new ArrayList<ItemPedido>();

	@Column(nullable = false, length = 100)
	private int quantidadePedir;

	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionarios_Pedido;

	@OneToMany(mappedBy = "pedidos", orphanRemoval = true)
	@Cascade(value= {org.hibernate.annotations.CascadeType.ALL})
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidadePedir() {
		return quantidadePedir;
	}

	public void setQuantidadePedir(int quantidadePedir) {
		this.quantidadePedir = quantidadePedir;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public Funcionario getFuncionarios() {
		return funcionarios_Pedido;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios_Pedido = funcionarios;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addItemPedido(ItemPedido ip) {
		itemspedidos.add(ip);
	}

	public void delMaterial(ItemPedido ip) {
		itemspedidos.remove(ip);
	}

	public List<ItemPedido> getItemspedidos() {
		return itemspedidos;
	}

	public void setItemspedidos(List<ItemPedido> itemspedidos) {
		this.itemspedidos = itemspedidos;
	}

	
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String toString() {
		return String.format(
				"Categoria [id=%d, status=\"%s\", numero total de itens=%d, quantidade de materiais a pedir=%d]", id,
				status, itemspedidos.size(), quantidadePedir);
	}

}
