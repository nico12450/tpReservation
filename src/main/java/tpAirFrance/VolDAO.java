package tpAirFrance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class VolDAO {
	
	public static void insererVol(Vol v) {
		
		EntityManager em = DatabaseHelper.createEntityManager();	
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static List<Vol> listeVols(){
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		List<Vol> l = new ArrayList<Vol>();
		
		TypedQuery<Vol> query = em.createQuery("select v from Vol v order by datedepart", Vol.class);
		l = (List<Vol>) query.getResultList();	
		
		em.close();
		
		return l;
		
	}

}
