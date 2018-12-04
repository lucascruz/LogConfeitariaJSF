package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class CategoriaTeste {

	public static void main(String[] args) {
		
		CategoriaRepositorio cr = new CategoriaRepositorio();
		
		
		Categoria c1, c2;
		List<Categoria> categorias;
		
		c1=new Categoria();
		c1.setId(1);
		c1.setNome("laticineos");
		c1.setDescricao("Tudo que vem da vaca");
	
		
		c2=new Categoria();
		c2.setId(2);
		c2.setNome("Massas");
		c2.setDescricao("Tudo que vem do trigo");
		
		
		System.out.println("Adicionando categorias...");
		cr.adicionar(c1);
		cr.adicionar(c2);
		
		System.out.println("Listando categorias..");
		categorias = cr.recuperarTodos();
		for(Categoria categoria : categorias) {
			System.out.println(categoria);
		}
		
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
		cr.encerrar();

	}

}
