package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;


public class ControladorDocente {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("docentesyasignaturas");

	
	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Docente> findByLikeDescripcion (String descripcion){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM docente where nombreCompleto like ? ;", Docente.class);
		q.setParameter(1, "%" + descripcion + "%");
		
		@SuppressWarnings("unchecked")
		List<Docente> l = (List<Docente>) q.getResultList();
		em.close();
		return l;
	}
}
