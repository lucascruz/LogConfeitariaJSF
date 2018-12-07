package br.ufac.logconf.repositorios;

import java.util.List;

import javax.persistence.*;
import br.ufac.logconf.entidades.*;

public class FuncionarioRepositorio {


        private EntityManagerFactory emf;
        private EntityManager em;
        
        public FuncionarioRepositorio() {
            emf = Persistence.createEntityManagerFactory("AcademicoJPA");
            em = emf.createEntityManager();
        }
        
        public void adicionar(Funcionario funcionario) {
            
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
            
        }
        
        public Funcionario recuperar(int id) {
            return em.find(Funcionario.class, id);
        }
        
        public void atualizar(Funcionario funcionario) {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
        }
        public void remover(Funcionario funcionario) {
            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();
        }
        @SuppressWarnings("unchecked")
        public List<Funcionario> recuperarTodos(){
            return em.createNamedQuery("Funcionario.todos").getResultList();
            
        }
        @SuppressWarnings("unchecked")
        public List<Funcionario> recuperarTodosPorNome(){
            return em.createNamedQuery("Funcionario.todosPorNome").getResultList();
            
        }
        
        @SuppressWarnings("unchecked")
        public List<Funcionario> recuperarTodosPorID(int id){
            return em.createNamedQuery("Funcionario.todosPorID").setParameter("id", id).getResultList();
            
        }

        public void encerrar() {
            em.close();
            emf.close();
        }
    }