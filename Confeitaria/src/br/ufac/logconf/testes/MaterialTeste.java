package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class MaterialTeste {

	public static void main(String[] args) {

		CategoriaRepositorio cr = new CategoriaRepositorio();
		MaterialRepositorio mr = new MaterialRepositorio();
		ItemPedidoRepositorio ipr = new ItemPedidoRepositorio();

		Material m1, m2, m3;
		Categoria c1, c2;
		ItemPedido ip1;

		List<Material> materiais;

		ip1 = ipr.recuperar(1);

		c1 = cr.recuperar(1);
		c2 = cr.recuperar(2);

		m1 = new Material();
		m1.setId(11);
		m1.setNome("Leite");
		m1.setDescricao("LeiteBom");
		m1.setDataValidade("12/10/2010");
		m1.setCategoria(c1);

		m2 = new Material();
		m2.setId(22);
		m2.setNome("Margarina");
		m2.setDescricao("Delicia");
		m2.setDataValidade("12/10/2010");
		m2.setCategoria(c2);

		m3 = new Material();
		m3.setId(33);
		m3.setNome("Trigo");
		m3.setDescricao("Sol");
		m3.setDataValidade("12/10/2010");
		m3.setCategoria(c1);

		System.out.println("Adicionando materiais...");
		mr.adicionar(m1);
		mr.adicionar(m2);
		mr.adicionar(m3);

		m1.addItem(ip1);
		m1.addItem(ip1);
		m1.addItem(ip1);
		
		System.out.println("Listando material...");
		materiais = mr.recuperarTodos();
		for (Material material : materiais) {
			System.out.println(material);
		}

		System.out.println("Recuperando material, id = 1");
		m1 = mr.recuperar(11);

		m1.setNome("Porco");
		m1.setDescricao("Bacon");
		m1.setDataValidade("12/10/2010");
		m1.setCategoria(c1);

		System.out.println("Atualizando material, id = 1");
		//mr.atualizar(m1);

		System.out.println("Listando Materiais, todos...");
		materiais = mr.recuperarTodos();
		for (Material material : materiais) {
			System.out.println(material);
		}

//		System.out.println("Removendo materiais..");
//		materiais = mr.recuperarTodos();
//		for(Material material : materiais) {
//			mr.remover(material);
//		}
		System.out.println("Listando materiais..");
		materiais = mr.recuperarTodos();
		for (Material material : materiais) {
			System.out.println(material);
		}
		ipr.encerrar();
		mr.encerrar();
		cr.encerrar();

	}

}
