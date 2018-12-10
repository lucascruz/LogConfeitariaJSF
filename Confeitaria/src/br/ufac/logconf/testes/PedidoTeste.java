package br.ufac.logconf.testes;


import java.util.Calendar;
import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class PedidoTeste {

	public static void main(String[] args) {
		
		PedidoRepositorio pr = new PedidoRepositorio();
		ItemPedidoRepositorio ipr = new ItemPedidoRepositorio();
		
		ItemPedido ip1, ip2, ip3;
		Pedido p1, p2, p3;
		
		List<Pedido> pedidos;
		
		
		
		ip1=ipr.recuperar(1);
		ip2=ipr.recuperar(2);
		ip3=ipr.recuperar(3);
		
		
		System.out.println("Adicionando items no pedido..1");
		p1=new Pedido();
		p1.setId(1);
		p1.setStatus("Solicitado");
		p1.setDataEntrada(Calendar.getInstance());
		p1.setDataSaida(Calendar.getInstance());
		p1.setQuantidadePedir(10);
		p1.addItemPedido(ip1);
		System.out.println("Adicionados");
		System.out.println(p1.getItemspedidos().size());

	
		System.out.println("Adicionando items no pedido..2");
		p2=new Pedido();
		p2.setId(2);
		p2.setStatus("Solicitado");
		p2.setDataEntrada(Calendar.getInstance());
		p2.setDataSaida(Calendar.getInstance());
		p2.setQuantidadePedir(10);
		p2.addItemPedido(ip2);
		System.out.println("Adicionados");
		System.out.println(p2.getItemspedidos().size());
		
		System.out.println("Adicionando items no pedido..3");
		p3=new Pedido();
		p3.setId(3);
		p3.setStatus("Solicitado");
		p3.setDataEntrada(Calendar.getInstance());
		p3.setDataSaida(Calendar.getInstance());
		p3.setQuantidadePedir(10);
		p3.addItemPedido(ip3);
		System.out.println("Adicionados");
		System.out.println(p3.getItemspedidos().size());

		pr.adicionar(p1);
		pr.adicionar(p2);
		pr.adicionar(p3);

	
		System.out.println("Listando Pedido, todos...");
		pedidos = pr.recuperarTodos();
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}

		
		
		
//		c2=new Categoria();
//		c2.setId(2);
//		c2.setNome("Massas");
//		c2.setDescricao("Tudo que vem do trigo");
//		
//		
//		System.out.println("Adicionando categorias...");
//		cr.adicionar(c1);
//		cr.adicionar(c2);
//		
//		System.out.println("Listando categorias..");
//		categorias = cr.recuperarTodos();
//		for(Categoria categoria : categorias) {
//			System.out.println(categoria);
//		}
		
//		System.out.println("Recuperando categorias, id = 444");
//		a4=ar.recuperar(444);
//		a4.setNome("LOA");
//		a4.setSexo("F");
//		
//		System.out.println("Atualizando categoria, id = 444");
//		ar.atualizar(a4);
//		
//		System.out.println("Recuperando categorias id= 555");
//		a4=ar.recuperar(555);
//		a4.setNome("Alial");
//		a4.setSexo("M");
//		
//		System.out.println("Atualizando categoria, id = 555");
//		ar.atualizar(a5);
//		
//		System.out.println("Listando categorias, todos...");
//		categorias = ar.recuperarTodos();
//		for(Categoria categoria : categorias) {
//			System.out.println(categoria);
//		}
//		
//		System.out.println("Removendo categorias..");
//		categorias = ar.recuperarTodos();
//		for(Categoria categoria : categorias) {
//			ar.remover(categoria);
//		}
//		System.out.println("Listando categorias,nenhum..");
//		categorias = ar.recuperarTodos();
//		for(Categoria categoria : categorias) {
//			System.out.println(categoria);
//		}
		ipr.encerrar();
		pr.encerrar();
	}

}
