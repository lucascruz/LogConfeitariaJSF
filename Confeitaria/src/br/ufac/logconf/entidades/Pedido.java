package br.ufac.logconf.entidades;

import java.util.*;

import javax.persistence.*;




@Entity
@Table(name="pedidos")
@NamedQueries({
@NamedQuery(name="Pedido.todos", query="SELECT p FROM Pedido p"),
@NamedQuery(name="Pedido.todosPorID", query="SELECT p FROM Pedido p WHERE p.id LIKE :id ORDER BY p.id")
})

public class Pedido {

	@Id
	private int id;
	@Column(nullable=false, length=50)
	private String status;
	@Column(nullable=false, length=10)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrada;
	@Column(nullable=false, length=10)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataSaida;
	
	public Funcionario getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}
	@OneToMany(mappedBy="pedido",cascade=CascadeType.ALL)
	private List<ItemPedido> itemspedidos;
	
	@Column(nullable=false, length=100)
	private int quantidadePedir;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private Funcionario funcionarios;
	
	
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
	public String toString() {
		return String.format("Categoria [id=%d, status=\"%s\", numero total de itens=%d, quantidade de materiais a pedir=%d]", id, status, itemspedidos.size(), quantidadePedir);
	}
	
}
