package tpAirFrance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReservationDAO {

	public static void insererReservation(Reservation r) {
		
		EntityManager em = DatabaseHelper.createEntityManager();	
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static List<Reservation> listeReservations() {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		List<Reservation> l = new ArrayList<Reservation>();
		
		TypedQuery<Reservation> query = em.createQuery("select r from Reservation r", Reservation.class);
		l = (List<Reservation>) query.getResultList();	
		
		em.close();
		
		return l;
		
	}
	
	public static List<Reservation> getReservationsByVol(String n){
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.numVol=:n", Vol.class);
		query.setParameter("n", n);
		Vol v = query.getSingleResult();
		List<Reservation> l = v.getReservationsClients();
		em.close();
		
		return l;
		
	}
	
	public static void annulerReservation(String num) {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Vol> query = em.createQuery("select r from Reservation r where r.num=:num", Vol.class);
		query.setParameter("num", num);
		query.executeUpdate();
		em.close();
		
	}
	
	
	
}
