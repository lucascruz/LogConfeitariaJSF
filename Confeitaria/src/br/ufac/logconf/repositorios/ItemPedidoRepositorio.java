package br.ufac.logconf.repositorios;

import java.util.List;

import javax.persistence.*;
import br.ufac.logconf.entidades.*;

public class ItemPedidoRepositorio {


		private EntityManagerFactory emf;
		private EntityManager em;
		
		public ItemPedidoRepositorio() {
			emf = Persistence.createEntityManagerFactory("AcademicoJPA");
			em = emf.createEntityManager();
		}
		
		public void adicionar(ItemPedido itempedido) {
			
			em.getTransaction().begin();
			em.persist(itempedido);
			em.getTransaction().commit();
			
		}
		
		public ItemPedido recuperar(int id) {
			return em.find(ItemPedido.class, id);
			
		}
		
		public void atualizar(ItemPedido itempedido) {
			em.getTransaction().begin();
			em.merge(itempedido);
			em.getTransaction().commit();
		}
		public void remover(ItemPedido itempedido) {
			em.getTransaction().begin();
			em.remove(itempedido);
			em.getTransaction().commit();
		}
		@SuppressWarnings("unchecked")
		public List<ItemPedido> recuperarTodos(){
			return em.createNamedQuery("ItemPedido.todos").getResultList();
			
		}
		@SuppressWarnings("unchecked")
		public List<ItemPedido> recuperarTodosPorNome(){
			return em.createNamedQuery("ItemPedido.todosPorNome").getResultList();
			
		}
		
		@SuppressWarnings("unchecked")
		public List<Pedido> recuperarTodosPorID(int id){
			return em.createNamedQuery("Pedido.todosPorID").setParameter("id", id).getResultList();
			
		}

		
		public void encerrar() {
			em.close();
			emf.close();
		}
	}



