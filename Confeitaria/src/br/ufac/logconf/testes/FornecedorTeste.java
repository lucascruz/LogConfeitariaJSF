package br.ufac.logconf.testes;

import java.util.ArrayList;
import java.util.List;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

public class FornecedorTeste {
	public static void main(String[] args) {

		FornecedorRepositorio or = new FornecedorRepositorio();
		FuncionarioRepositorio fr = new FuncionarioRepositorio();
		CategoriaRepositorio cr = new CategoriaRepositorio();

		Fornecedor o1, o2;
		Funcionario f1;
		Categoria c1, c2;

		c1 = cr.recuperar(1);
		c2 = cr.recuperar(2);

		o1 = or.recuperar(1);

		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(c1);
		categorias.add(c2);

		f1 = fr.recuperar(1);

		List<Fornecedor> fornecedores;

		o1 = new Fornecedor();
		o1.setId(1);
		o1.setNome("Laila");
		o1.setCnpj("123");
		o1.setEndereco("Minha rua");
		o1.setTelefone("456");
		o1.setEmail("laila@hot");
		o1.setFuncionarios(f1);
		o1.setCategorias(categorias);

		o2 = new Fornecedor();
		o2.setId(2);
		o2.setNome("Lucas");
		o2.setCnpj("789");
		o2.setEndereco("Rua dele");
		o2.setTelefone("0123");
		o2.setEmail("lucas@hot");
		o2.setFuncionarios(f1);
	//	o2.setCategorias(categorias);

		System.out.println("Adicionando fornecedor...");
		or.adicionar(o1);
		or.adicionar(o2);

		System.out.println("Listando fornecedor...");
		fornecedores = or.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}

		System.out.println("Recuperando fornecedores, id = 2");
		o2 = or.recuperar(2);
		o2.setId(2);
		o2.setNome("Atacadão");
		o2.setCnpj("7909");
		o2.setEndereco("Rua dele");
		o2.setTelefone("0123");
		o2.setEmail("lucas@hot");
		o2.setFuncionarios(f1);
 //       o2.setCategorias(categorias);

		System.out.println("Atualizando fornecedor, id = 1");
		or.atualizar(o2);

		System.out.println("Listando fornecedores, todos...");
		fornecedores = or.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}

		System.out.println("Removendo fornecedores..");
		fornecedores = or.recuperarTodos();
		// or.remover(o1);
//		for(Categoria categoria : categorias) {
//			ar.remover(categoria);
//		}
		System.out.println("Listando categorias...");
		fornecedores = or.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}

		fr.encerrar();
		or.encerrar();
	}
}
