package tpAirFrance;

import javax.persistence.EntityManager;

public class ReservationDAO {

	public static void insererReservation(Reservation r) {
		
		EntityManager em = DatabaseHelper.createEntityManager();	
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
