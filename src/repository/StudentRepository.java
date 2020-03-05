package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Student;


public class StudentRepository {
		private final EntityManagerFactory emf;
		
		public StudentRepository() {
			emf = Persistence.createEntityManagerFactory("Example01PU");
		}
		
		public void save(Student student) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(student);
			System.out.println("STUDENT.....merged!");
			em.getTransaction().commit();

			em.close();
		}
	}


