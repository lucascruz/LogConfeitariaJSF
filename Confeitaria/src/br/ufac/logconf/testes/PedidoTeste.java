package br.ufac.logconf.testes;

import java.util.Calendar;
import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class PedidoTeste {

	public static void main(String[] args) {

		PedidoRepositorio pr = new PedidoRepositorio();
		FuncionarioRepositorio fr = new FuncionarioRepositorio();
		ItemPedidoRepositorio ipr = new ItemPedidoRepositorio();

		ItemPedido ip1, ip2, ip3;
		Funcionario f1;
		Pedido p1, p2, p3;

		List<Pedido> pedidos;

		f1 = fr.recuperar(1);
		
		ip1 = ipr.recuperar(1);
		ip2 = ipr.recuperar(2);
		ip3 = ipr.recuperar(3);
		


		// p3 = pr.recuperar(3);

		System.out.println("Adicionando items no pedido..1");
		p1 = new Pedido();
		p1.setId(1);
		p1.setStatus("Solicitado");
		p1.setDataEntrada(Calendar.getInstance());
		p1.setDataSaida(Calendar.getInstance());
		p1.addItemPedido(ip1);;
		p1.setQuantidadePedir(10);
		p1.setFuncionarios_Pedido(f1);
		System.out.println("Adicionados");
		System.out.println(p1.getItemspedidos().size());

		System.out.println("Adicionando items no pedido..2");
		p2 = new Pedido();
		p2.setId(2);
		p2.setStatus("Aguardando");
		p2.setDataEntrada(Calendar.getInstance());
		p2.setDataSaida(Calendar.getInstance());
		p2.addItemPedido(ip2);
		p2.setQuantidadePedir(10);
		p2.setFuncionarios_Pedido(f1);
		System.out.println("Adicionados");
		System.out.println(p2.getItemspedidos().size());

		System.out.println("Adicionando items no pedido..3");
		p3 = new Pedido();
		p3.setId(3);
		p3.setStatus("Cancelado");
		p3.setDataEntrada(Calendar.getInstance());
		p3.setDataSaida(Calendar.getInstance());
		p3.addItemPedido(ip3);
		p3.setQuantidadePedir(10);
		p3.setFuncionarios_Pedido(f1);
		System.out.println("Adicionados");
		System.out.println(p3.getItemspedidos().size());

		pr.adicionar(p1);
		pr.adicionar(p2);
		pr.adicionar(p3);

		System.out.println("Listando pedidos..");
		pedidos = pr.recuperarTodos();
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}

		System.out.println("Recuperando pedidos, id = 2");
		p2 = pr.recuperar(2);
		p2.setStatus("Em andamento");
		p2.setDataEntrada(Calendar.getInstance());
		p2.setDataSaida(Calendar.getInstance());
		p2.setQuantidadePedir(25);

		System.out.println("Atualizando Pedido, id = 2");
		pr.atualizar(p2);

		System.out.println("Listando pedidos, todos...");
		pedidos = pr.recuperarTodos();
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}

//		System.out.println("Removendo pedidos..");
//		pedidos = pr.recuperarTodos();
//		pr.remover(p3);

		System.out.println("Listando pedidos..");
		pedidos = pr.recuperarTodos();
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}
		ipr.encerrar();
		fr.encerrar();
		pr.encerrar();
	}

}
