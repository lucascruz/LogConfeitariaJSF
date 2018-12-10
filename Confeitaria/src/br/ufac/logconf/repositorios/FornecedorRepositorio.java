package br.ufac.logconf.repositorios;

import java.util.List;

import javax.persistence.*;
import br.ufac.logconf.entidades.*;

public class FornecedorRepositorio {


        private EntityManagerFactory emf;
        private EntityManager em;
        
        public FornecedorRepositorio() {
            emf = Persistence.createEntityManagerFactory("AcademicoJPA");
            em = emf.createEntityManager();
        }
        
        public void adicionar(Fornecedor fornecedor) { 
            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();         
        }
        
        public Fornecedor recuperar(int id) {
            return em.find(Fornecedor.class, id);
        }
        
        public void atualizar(Fornecedor fornecedor) {
            em.getTransaction().begin();
            em.merge(fornecedor);
            em.getTransaction().commit();
        }
        public void remover(Fornecedor fornecedor) {
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
        }
        @SuppressWarnings("unchecked")
        public List<Fornecedor> recuperarTodos(){
            return em.createNamedQuery("Fornecedor.todos").getResultList();
            
        }
        
        @SuppressWarnings("unchecked")
        public List<Fornecedor> recuperarTodosPorID(int id){
            return em.createNamedQuery("Fornecedor.todosPorID").setParameter("id", id).getResultList();
            
        }

        public void encerrar() {
            em.close();
            emf.close();
        }
    }