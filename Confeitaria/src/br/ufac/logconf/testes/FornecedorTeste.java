package br.ufac.logconf.testes;

import java.util.List;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;


public class FornecedorTeste {
    public static void main(String[] args) {

        FornecedorRepositorio or = new FornecedorRepositorio();
        FuncionarioRepositorio fr = new FuncionarioRepositorio();

        Fornecedor o1, o2;
        Funcionario f1;
        
        
        
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
        
        o2 = new Fornecedor();
        o2.setId(2);
        o2.setNome("Lucas");
        o2.setCnpj("789"); 
        o2.setEndereco("Rua dele");
        o2.setTelefone("0123");
        o2.setEmail("lucas@hot");
        o1.setFuncionarios(f1);
       


        System.out.println("Adicionando fornecedor...");
        or.adicionar(o1);
        or.adicionar(o2);
       


        System.out.println("Listando fornecedor...");
        fornecedores = or.recuperarTodos();
        for(Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
        
        
        or.encerrar();
    }
}


