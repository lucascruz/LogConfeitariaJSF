package br.ufac.logconf.repositorios;

import java.util.List;

import javax.persistence.*;
import br.ufac.logconf.entidades.*;

public class CategoriaRepositorio {


		private EntityManagerFactory emf;
		private EntityManager em;
		
		public CategoriaRepositorio() {
			emf = Persistence.createEntityManagerFactory("AcademicoJPA");
			em = emf.createEntityManager();
		}
		
		public void adicionar(Categoria categoria) {
			
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
			
		}
		
		public Categoria recuperar(int id) {
			return em.find(Categoria.class, id);
		}
		
		public void atualizar(Categoria categoria) {
			em.getTransaction().begin();
			em.merge(categoria);
			em.getTransaction().commit();
		}
		public void remover(Categoria categoria) {
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
		}
		@SuppressWarnings("unchecked")
		public List<Categoria> recuperarTodos(){
			return em.createNamedQuery("Categoria.todos").getResultList();
			
		}
		@SuppressWarnings("unchecked")
		public List<Categoria> recuperarTodosPorNome(){
			return em.createNamedQuery("Categoria.todosPorNome").getResultList();
			
		}
		
		@SuppressWarnings("unchecked")
		public List<Categoria> recuperarTodosPorID(int id){
			return em.createNamedQuery("Categoria.todosPorID").setParameter("id", id).getResultList();
			
		}

		public void encerrar() {
			em.close();
			emf.close();
		}
	}



