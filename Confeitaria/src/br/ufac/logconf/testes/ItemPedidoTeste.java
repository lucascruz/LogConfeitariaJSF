package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.entidades.ItemPedido;
import br.ufac.logconf.entidades.Material;
import br.ufac.logconf.entidades.Pedido;
import br.ufac.logconf.repositorios.ItemPedidoRepositorio;
import br.ufac.logconf.repositorios.MaterialRepositorio;

public class ItemPedidoTeste {
	public static void main(String[] args) {

		ItemPedidoRepositorio ipr = new ItemPedidoRepositorio();
		MaterialRepositorio mr = new MaterialRepositorio();

		ItemPedido ip1 = new ItemPedido();
		ItemPedido ip2 = new ItemPedido();
		ItemPedido ip3 = new ItemPedido();

		Material m1, m2, m3;

		Pedido p1 = new Pedido();

		List<ItemPedido> itempedidos;

		m1 = mr.recuperar(11);
		m2 = mr.recuperar(22);
		m3 = mr.recuperar(33);

		ip1.setId(1);
		ip1.setMaterial(m1);
		ip1.setQuantidade(10);
		p1.addItemPedido(ip1);


		ip2.setId(2);
		ip2.setMaterial(m2);
		ip2.setQuantidade(5);
		p1.addItemPedido(ip2);


		ip3.setId(3);
		ip3.setMaterial(m3);
		ip3.setQuantidade(10);
		p1.addItemPedido(ip2);


		System.out.println(ip1.toString());
		System.out.println(ip2.toString());
		System.out.println(ip3.toString());

		ipr.adicionar(ip1);
		ipr.adicionar(ip2);
		ipr.adicionar(ip3);
		
		ip1.setPedido(p1);
		ip2.setPedido(p1);
		ip3.setPedido(p1);

		System.out.println("Listando itens...");
		itempedidos = ipr.recuperarTodos();
		for (ItemPedido itempedido : itempedidos) {
			System.out.println(itempedido);
		}
		ipr.encerrar();
		mr.encerrar();
	}
}
