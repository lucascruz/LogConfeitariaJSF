package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class MaterialTeste {

	public static void main(String[] args) {
		
		CategoriaRepositorio cr = new CategoriaRepositorio();
		MaterialRepositorio mr = new MaterialRepositorio();
		
		
		Material m1, m2, m3;
		Categoria c1, c2;
		
		c1 = cr.recuperar(1);
		c2 = cr.recuperar(2);
		
		List<Material> materiais;
		
		m1 = new Material();
		m1.setId(11);
		m1.setNome("Leite");
		m1.setDescricao("LeiteBom");
		m1.setQuantidade(5);
		m1.setDataEntrada("27/11");
		m1.setDataSaida("28/11");
		m1.setCategoria(c1);
		
		
		m2 = new Material();
		m2.setId(22);
		m2.setNome("Margarina");
		m2.setDescricao("Delicia");
		m2.setQuantidade(3);
		m2.setDataEntrada("24/11");
		m2.setDataSaida("29/11");
		m2.setCategoria(c1);
		
		m3 = new Material();
		m3.setId(33);
		m3.setNome("Trigo");
		m3.setDescricao("Sol");
		m3.setQuantidade(10);
		m3.setDataEntrada("02/11");
		m3.setDataSaida("29/11");
		m3.setCategoria(c2);
		
		
		
		System.out.println("Adicionando materiais...");
		mr.adicionar(m1);
		mr.adicionar(m2);
		mr.adicionar(m3);
				
		
		System.out.println("Listando material...");
		materiais = mr.recuperarTodos();
		for(Material material : materiais) {
			System.out.println(material);
		}
		
//		System.out.println("Recuperando categorias, id = 444");
//		a4=ar.recuperar(444);
//		a4.setNome("LOA");
//		a4.setSexo("F");
		
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
		
		mr.encerrar();
		cr.encerrar();

	}

}
