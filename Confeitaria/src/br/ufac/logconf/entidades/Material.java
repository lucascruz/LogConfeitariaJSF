package br.ufac.logconf.entidades;
//import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="materiais")
@NamedQueries({
@NamedQuery(name="Material.todos", query="SELECT m FROM Material m"),
@NamedQuery(name="Material.todosPorNome", query="SELECT m FROM Material m ORDER BY m.nome"),
@NamedQuery(name="Material.todosPorID", query="SELECT m FROM Material m WHERE m.id LIKE :id ORDER BY m.id")
})
public class Material {

	@Id
	private int id;
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=false, length=100)
	private String descricao;
	@Column(nullable=false, length=3)
	private int quantidade;
	@Column(nullable=false, length=10)
	private String dataEntrada;
	@Column(nullable=false, length=10)
	private String dataSaida;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="categoria_fk")
	private Categoria categoria;	

	@ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "solicitacao_fk")
	 private Pedido pedido;
	
	
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
		
	}
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String toString() {
		return String.format("Material [id=%d, nome=\"%s\", descricao=\"%s\", quantidade=%d, dataEntrada=\"%s\", dataSaida=\"%s\", categoria=\"%s\"]", id, nome, descricao, quantidade, dataEntrada, dataSaida, categoria);
	}

	
	
	
	
}
