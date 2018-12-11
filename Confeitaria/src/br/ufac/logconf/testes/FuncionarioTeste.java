package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

public class FuncionarioTeste {
	public static void main(String[] args) {

		FuncionarioRepositorio fr = new FuncionarioRepositorio();

		Funcionario f1, f2, f3;
		f3 = fr.recuperar(3);

		List<Funcionario> funcionarios;

        f1 = new Funcionario();
        f1.setId(1);
        f1.setNome("Laila");
        f1.setCpf("000");
        f1.setEndereco("skld");
        f1.setIdade(54);
        f1.setSexo("1");
        f1.setTelefone("dff");


        f2 = new Funcionario();
        f2.setId(2);
        f2.setNome("Oliveira");
        f2.setCpf("111");
        f2.setEndereco("skld");
        f2.setIdade(54);
        f2.setSexo("1");
        f2.setTelefone("dff");
    

        f3 = new Funcionario();
        f3.setId(3);
        f3.setNome("Assad");
        f3.setCpf("222");
        f3.setEndereco("skld");
        f3.setIdade(54);
        f3.setSexo("1");
        f3.setTelefone("dff");
    
 


        System.out.println("Adicionando funcionario...");
        fr.adicionar(f1);
        fr.adicionar(f2);
        fr.adicionar(f3);


		System.out.println("Listando funcionario...");
		funcionarios = fr.recuperarTodos();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		System.out.println("Recuperando funcionario, id = 2");
		f2 = fr.recuperar(2);
		f2.setNome("Oliveira");
		f2.setCpf("222");
		f2.setEndereco("loa");
		f2.setIdade(14);
		f2.setSexo("1");
		f2.setTelefone("dff");

		System.out.println("Atualizando aluno, id = 2");
		fr.atualizar(f2);

		System.out.println("Listando funcionarios, todos...");
		funcionarios = fr.recuperarTodos();
		for (Funcionario aluno : funcionarios) {
			System.out.println(aluno);
		}

		System.out.println("Removendo funcionarios..");
		funcionarios = fr.recuperarTodos();
		fr.remover(f3);
//		for(Funcionario funcionario : funcionarios) {
//			fr.remover(funcionario);
		// }
		System.out.println("Listando funcionarios...");
		funcionarios = fr.recuperarTodos();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		fr.encerrar();
	}
}
