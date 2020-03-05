package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Profesor;


public class ProfesorRepository {
	private final EntityManagerFactory emf;
	
	public ProfesorRepository() {
		emf = Persistence.createEntityManagerFactory("Example01PU");
	}
	
	public void save(Profesor profesor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(profesor);
		System.out.println("PROFESOR.....merged!");
		em.getTransaction().commit();

		em.close();
	}
}
