package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.repositorios.*;
import br.ufac.logconf.entidades.*;

public class CategoriaTeste {

	public static void main(String[] args) {

		FornecedorRepositorio fr = new FornecedorRepositorio();
		CategoriaRepositorio cr = new CategoriaRepositorio();

		Categoria c1, c2;
		Fornecedor f1, f2;

		f1 = fr.recuperar(1);
		f2 = fr.recuperar(2);

		c2 = cr.recuperar(2);

		List<Fornecedor> fornecedores;
		List<Categoria> categorias;

		c1 = new Categoria();
		c1.setId(1);
		c1.setNome("laticineos");
		c1.setDescricao("Tudo que vem da vaca");
		c1.setFornecedor(f1);

		c2 = new Categoria();
		c2.setId(2);
		c2.setNome("Massas");
		c2.setDescricao("Tudo que vem do trigo");
		c2.setFornecedor(f2);

		System.out.println("Adicionando categorias...");
		cr.adicionar(c1);
		cr.adicionar(c2);

		System.out.println("Listando categorias..");
		categorias = cr.recuperarTodos();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}

		System.out.println("Listando fornecedores..");
		fornecedores = fr.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}

		System.out.println("Recuperando categorias, id = 444");
		c1 = cr.recuperar(1);
		c1.setNome("Carne");
		c1.setDescricao("Tudo que vem da carne");
		c1.setFornecedor(f2);

		System.out.println("Atualizando categoria, id = 1");
		cr.atualizar(c1);

		System.out.println("Listando categorias, todos...");
		categorias = cr.recuperarTodos();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}

//		System.out.println("Removendo categorias..");
//		categorias = cr.recuperarTodos();
//		cr.remover(c2);
//		for(Categoria categoria : categorias) {
//			ar.remover(categoria);
//		}
		System.out.println("Listando categorias...");
		categorias = cr.recuperarTodos();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
		cr.encerrar();
		fr.encerrar();

	}

}
