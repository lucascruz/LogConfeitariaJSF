package br.ufac.logconf.repositorios;

import java.util.List;

import javax.persistence.*;
import br.ufac.logconf.entidades.*;

public class MaterialRepositorio {


		private EntityManagerFactory emf;
		private EntityManager em;
		
		public MaterialRepositorio() {
			emf = Persistence.createEntityManagerFactory("AcademicoJPA");
			em = emf.createEntityManager();
		}
		
		public void adicionar(Material material) {
			
			em.getTransaction().begin();
			em.persist(material);
			em.getTransaction().commit();
			
		}
		
		public Material recuperar(int id) {
			return em.find(Material.class, id);
			
		}
		
		public void atualizar(Material material) {
			em.getTransaction().begin();
			em.merge(material);
			em.getTransaction().commit();
		}
		public void remover(Material material) {
			em.getTransaction().begin();
			em.remove(material);
			em.getTransaction().commit();
		}
		@SuppressWarnings("unchecked")
		public List<Material> recuperarTodos(){
			return em.createNamedQuery("Material.todos").getResultList();
			
		}
		@SuppressWarnings("unchecked")
		public List<Material> recuperarTodosPorNome(){
			return em.createNamedQuery("Material.todosPorNome").getResultList();
			
		}
		
		@SuppressWarnings("unchecked")
		public List<Material> recuperarTodosPorID(int id){
			return em.createNamedQuery("Material.todosPorID").setParameter("id", id).getResultList();
			
		}

		
		public void encerrar() {
			em.close();
			emf.close();
		}
	}



