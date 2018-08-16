package br.com.stos.agenda.HibernateDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.stos.agenda.model.Contato;

public class ContatoHibernateDao {
	
	private static final String PERSISTENCE_UNIT = "agenda";
	
	public void salvar(Contato contato) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		}
	
	public void alterar(Contato contato) {
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		}
	
	public void remover(int id) {
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Contato contato = manager.find(Contato.class, id);
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		}
	
	public Contato buscarPorId(int id) {
		Contato obj = null;
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		obj = manager.find(Contato.class, id);
		manager.close();
		factory.close();
		return obj;
		}

	public List<Contato> listar() {
		List<Contato> listar = null;
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		listar = manager.createQuery("SELECT c FROM Contato c ORDER BY c.nome").getResultList();
		manager.close();
		factory.close();
		return listar;
		}
	
}
