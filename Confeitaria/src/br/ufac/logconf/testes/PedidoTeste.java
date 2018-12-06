package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class PedidoTeste {

	public static void main(String[] args) {
		
		PedidoRepositorio pr = new PedidoRepositorio();
		MaterialRepositorio mr = new MaterialRepositorio();
		
		Material m1, m2, m3;
		Pedido p1, p2, p3;
		
		List<Pedido> pedidos;
		
		
		
		m1=mr.recuperar(11);
		m2=mr.recuperar(22);
		m3=mr.recuperar(33);
		m3=mr.recuperar(33);
		
	
		p1=new Pedido();
		p1.setId(1);
		p1.setStatus("Efetuado");
		System.out.println("Adicionando items no pedido..");
		p1.addMaterial(m1);
		p1.addMaterial(m2);
		p1.addMaterial(m3);
		
		pr.adicionar(p1);
		m1.setPedido(p1);
		
		
		p2=new Pedido();
		p2.setId(2);
		p2.setStatus("N�o enviado");
		System.out.println("Adicionando items no pedido..");
		p2.addMaterial(m1);
		p2.addMaterial(m2);
		p2.addMaterial(m2);
		
		pr.adicionar(p2);
		m2.setPedido(p2);
	
		p3=new Pedido();
		p3.setId(3);
		p3.setStatus("Retornando");
		System.out.println("Adicionando items no pedido..");
		p3.addMaterial(m1);
		p3.addMaterial(m3);
		p3.addMaterial(m3);
		
		
		pr.adicionar(p3);
		m3.setPedido(p3);
		
	
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
		pr.encerrar();
		mr.encerrar();
	}

}
