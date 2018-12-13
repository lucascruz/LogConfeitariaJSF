package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

public class FornecedorTeste {
	public static void main(String[] args) {

		FornecedorRepositorio or = new FornecedorRepositorio();
		CategoriaRepositorio cr = new CategoriaRepositorio();

		Fornecedor o1, o2;
		Categoria c1, c2;

		c1 = cr.recuperar(1);
		//c2 = cr.recuperar(2);

		o1 = or.recuperar(1);
		o2 = or.recuperar(2);

		List<Fornecedor> fornecedores;

/*		o1 = new Fornecedor();
		o1.setId(1);
		o1.setNome("Laila");
		o1.setCnpj("123");
		o1.setEndereco("Minha rua");
		o1.setTelefone("456");
		o1.setEmail("laila@hot");*/
		o1.setCategorias(c1);



/*		o2 = new Fornecedor();
		o2.setId(2);
		o2.setNome("Lucas");
		o2.setCnpj("789");
		o2.setEndereco("Rua dele");
		o2.setTelefone("0123");
		o2.setEmail("lucas@hot");*/
		o2.setCategorias(c1);

		System.out.println("Adicionando fornecedor...");
		or.atualizar(o1);
		or.atualizar(o2);

		/*System.out.println("Listando fornecedor...");
		fornecedores = or.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}*/

		/*System.out.println("Recuperando fornecedores, id = 2");
		o2 = or.recuperar(2);
		o2.setId(2);
		o2.setNome("Atacadão");
		o2.setCnpj("7909");
		o2.setEndereco("Rua dele");
		o2.setTelefone("0123");
		o2.setEmail("lucas@hot");

     

		System.out.println("Atualizando fornecedor, id = 1");
		or.atualizar(o2);

		System.out.println("Listando fornecedores, todos...");
		fornecedores = or.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}*/

		//System.out.println("Removendo fornecedores..");
		//fornecedores = or.recuperarTodos();
		// or.remover(o1);
//		for(Categoria categoria : categorias) {
//			ar.remover(categoria);
//		}
		System.out.println("Listando categorias...");
		fornecedores = or.recuperarTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
		cr.encerrar();
		or.encerrar();
	}
}
