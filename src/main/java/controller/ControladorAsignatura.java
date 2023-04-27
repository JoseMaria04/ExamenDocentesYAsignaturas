package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;


public class ControladorAsignatura {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("docentesyasignaturas");

	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Asignatura> findById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM docente where id = ? ;", Asignatura.class);
		q.setParameter(1, id);

		@SuppressWarnings("unchecked")
		List<Asignatura> l = (List<Asignatura>) q.getResultList();
		em.close();
		return l;
	}
}
