package br.ufac.logconf.entidades;
import java.sql.*;

import javax.persistence.*;

@Entity
@Table(name="funcionarios")
@NamedQueries({
@NamedQuery(name="Funcionario.todos", query="SELECT u FROM Funcionario u"),
@NamedQuery(name="Funcionario.todosPorNome", query="SELECT u FROM Funcionario u ORDER BY u.nome"),
@NamedQuery(name="Funcionario.todosPorID", query="SELECT u FROM Funcionario u WHERE u.id LIKE :id ORDER BY u.id")
})
public class Funcionario {

    @Id
    private int  id; 
    @Column(nullable=false, length=50)
    private String nome;
    @Column(nullable=false, length=50)
    private String cpf; 
    @Column(nullable=false, length=50)
    private String telefone;
//    @Column(nullable=false, length=50)
    private String sexo; 
//    @Column(nullable=false, length=50)
    private int idade; 
//    @Column(nullable=false, length=50)
    private String endereco; 
//    @Column(nullable=false, length=50)
    private String bairro; 
//    @Column(nullable=false, length=50)
    private String cep; 

//    @ManyToOne(cascade=CascadeType.MERGE)
//    @JoinColumn(name="fornecedor_fk")
//    private Fornecedor fornecedor;
    
    public Funcionario() {}


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
//    public Fornecedor getFornecedor() {
//        return fornecedor;
//    }
//    public void setFornecedor(Fornecedor fornecedor) {
//        this.fornecedor = fornecedor;
//}
    
    public String toString() {
        return String.format("Funcionario [id=%d, nome=\"%s\", cpf=\"%s\", telefone=\"%s\", sexo=\"%s\",idade=%d,endereco=\"%s\",bairro=\"%s\",cep=\"%s\"]", id, nome, cpf, telefone, sexo, idade, endereco, bairro, cep);
    }
    

}