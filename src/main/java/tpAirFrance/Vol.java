package tpAirFrance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vol")
public class Vol {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String numVol;
	
	@Enumerated(EnumType.STRING)
    @Column
	private TypeAvion type;
	
	@Column
	private int nbPlaces;
	
	@Column
	private String villeDepart;
	
	@Column
	private String villeArrivee;
	
	@Column
	private LocalDateTime dateDepart;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "volReserve")
	private List<Reservation> reservationsClients;
	
	public Vol() {
		
	}

	public Vol(String numVol, TypeAvion type, int nbPlaces, String villeDepart, String villeArrivee, LocalDateTime d) {
		super();
		this.numVol = numVol;
		this.type = type;
		this.nbPlaces = nbPlaces;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateDepart = d;
	}

	public String getNumVol() {
		return numVol;
	}

	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}

	public TypeAvion getType() {
		return type;
	}

	public void setType(TypeAvion type) {
		this.type = type;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public List<Reservation> getReservationsClients() {
		return reservationsClients;
	}

	public void setReservationsClients(List<Reservation> reservationsClients) {
		this.reservationsClients = reservationsClients;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		
		return "Vol [numVol=" + numVol + ", type=" + type + ", nbPlaces=" + nbPlaces + ", villeDepart=" + villeDepart
				+ ", villeArrivee=" + villeArrivee + ", dateDepart=" + dateDepart+"]";
	}

}
