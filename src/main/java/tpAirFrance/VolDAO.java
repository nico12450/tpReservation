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
	
	public static Vol getVolByNumber(String n) {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.numVol=:n", Vol.class);
		query.setParameter("n", n);
		Vol v = query.getSingleResult();
		
		em.close();
		
		return v;
	}
	
	public static List<Vol> getVolByVille(String d, String a) {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.villeDepart=:d and v.villeArrivee=:a", Vol.class);
		query.setParameter("d", d);
		query.setParameter("a", a);
		List<Vol> v = query.getResultList();
		
		em.close();
		
		return v;
		
	}

}
