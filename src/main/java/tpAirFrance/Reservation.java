package tpAirFrance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private int age;
	
	@ManyToOne
	private Vol VolReserve;
	
	public Reservation() {
		
	}

	public Reservation(String nom, String prenom, int age, Vol volReserve) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		VolReserve = volReserve;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vol getVolReserve() {
		return VolReserve;
	}

	public void setVolReserve(Vol volReserve) {
		VolReserve = volReserve;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Reservation [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", VolReserve=" + VolReserve + "]";
	}
	
	

}
