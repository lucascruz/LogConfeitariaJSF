package br.ufac.logconf.repositorios;

import java.util.List;

import javax.persistence.*;
import br.ufac.logconf.entidades.*;

public class PedidoRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;

	public PedidoRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Pedido pedidos) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(pedidos);
		em.getTransaction().commit();

	}
 
	public Pedido recuperar(int id) {
		return em.find(Pedido.class, id);
	}

	public void atualizar(Pedido pedidos) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.merge(pedidos);
		em.getTransaction().commit();
	}

	public void remover(Pedido pedidos) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.remove(pedidos);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> recuperarTodos() {
		return em.createNamedQuery("Pedido.todos").getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Pedido> recuperarTodosPorID(int id) {
		return em.createNamedQuery("Pedido.todosPorID").setParameter("id", id).getResultList();

	}

	public void encerrar() {
		em.close();
		emf.close();
	}
}
