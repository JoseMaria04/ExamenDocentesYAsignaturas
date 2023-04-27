package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Asignaturaspordocente;

public class ControladorAsignaturasPorDocente {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("docentesyasignaturas");

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Asignaturaspordocente> findById (int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Asignaturaspordocente where idDocente = ? ;", Asignaturaspordocente.class);
		q.setParameter(1, id);
		
		@SuppressWarnings("unchecked")
		List<Asignaturaspordocente> l = (List<Asignaturaspordocente>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Asignaturaspordocente> findAll (){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Asignaturaspordocente;", Asignaturaspordocente.class);
		
		@SuppressWarnings("unchecked")
		List<Asignaturaspordocente> l = (List<Asignaturaspordocente>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Asignaturaspordocente> findByIdDocente (int idDocente){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Asignaturaspordocente where idDocente = ?;", Asignaturaspordocente.class);
		q.setParameter(1, idDocente);

		
		@SuppressWarnings("unchecked")
		List<Asignaturaspordocente> l =  (List<Asignaturaspordocente>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 */
	public static void creacionAsignaturaPorDocente (Asignaturaspordocente l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void eliminarEntidad(Asignaturaspordocente l) {
		EntityManager em = entityManagerFactory.createEntityManager();		

		l = em.merge(l);
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}
}
