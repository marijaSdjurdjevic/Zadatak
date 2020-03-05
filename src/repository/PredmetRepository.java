package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Predmet;



public class PredmetRepository {
		private final EntityManagerFactory emf;
		
		public PredmetRepository() {
			emf = Persistence.createEntityManagerFactory("Example01PU");
		}
		
		public void save(Predmet predmet) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(predmet);
			System.out.println("PREDMET.....merged!");
			em.getTransaction().commit();

			em.close();
		}
	}

