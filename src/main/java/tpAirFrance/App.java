package tpAirFrance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	static Scanner sc;
	static boolean continuer = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*LocalDateTime d = LocalDateTime.of(2019,Month.OCTOBER,22,12,1,0);
		Vol v = new Vol("0001",TypeAvion.A340, 200, "Montpellier", "Toulouse", d);
		VolDAO.insererVol(v);*/
		
		sc = new Scanner(System.in);
		
		while(continuer) {
			choixMenu();
		}
		
		sc.close();

	}
	
	public static void choixMenu() {
		
		System.out.println("");
		System.out.println("1) gestion des vols");
		System.out.println("2) gestion des réservations");
		System.out.println("3) quitter");
		
		int choix = choix();
		
		switch(choix) {
		
			case 1:
				
				gestionVols();
				break;
				
			case 2:
				
				gestionReservations();
				break;
				
			case 3:
				
				System.out.println("fin du programme");
				continuer = false;
				break;
				
			default:
				
				choixInconnu();
					
		}
		
		
	}
	
	public static void gestionVols() {
		
		System.out.println("1) creation d'un vol");
		System.out.println("2) liste des vols");
		System.out.println("3) trouver vol avec numero");
		System.out.println("4) trouver vol avec villes");
		System.out.println("5) quitter");
		int choix = choix();
		
		switch(choix) {
		
		case 1:
			creerVol();
			break;
			
		case 2:
			afficherVols();
			break;
			
		case 3:
			trouverVolByNumber();
			break;
			
		case 4:
			trouverVolByVille();
			break;
			
		case 5:
			
			System.out.println("fin du programme");
			continuer = false;
			break;
			
		default:
			
			choixInconnu();
		
		}
		
	}
	
	public static void choixInconnu() {
		
		System.out.println("choix inconnu, entrez une nouvelle valeur: ");
		choixMenu();
		
	}
	
	public static int choix() {
		
		System.out.println("entrez votre choix : ");
		return Integer.parseInt(sc.nextLine());
		
	}
	
	public static void creerVol() {
		
		String numVol;
		TypeAvion ta;
		int nbPlaces;
		String villeD, villeA;
		LocalDateTime d;
		
		//System.out.println("création d'un vol");
		
		System.out.println("veuillez entrer le numéro de vol");
		
		numVol = sc.nextLine();
		
		System.out.println("veuillez entrer le type d'avion");
		
		ta = TypeAvion.valueOf(sc.nextLine());
		
		System.out.println("veuillez entrer le nombre de places");
		
		nbPlaces = Integer.parseInt(sc.nextLine());
		
		System.out.println("veuillez entrer la ville de départ");
		
		villeD = sc.nextLine();
		
		System.out.println("veuillez entrer la ville d'arrivée");
		
		villeA = sc.nextLine();
		
		System.out.println("veuillez entrer la date de départ au format yyyy-MM-dd HH:mm");
		d = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		
		Vol v = new Vol(numVol,ta,nbPlaces,villeD,villeA, d);
		
		VolDAO.insererVol(v);
		
		System.out.println("vol inséré");
		
	}
	
	public static void afficherVols() {
		
		ArrayList<Vol> l = (ArrayList<Vol>) VolDAO.listeVols();
		
		for(Vol v : l) {
			System.out.println(v);
		}
		
		//System.out.println(l);
		
	}
	
	public static Vol trouverVolByNumber() {
		
		System.out.println("entrez le numéro de l'avion ");
		
		String n = sc.nextLine();
		
		Vol v = VolDAO.getVolByNumber(n);
		
		System.out.println(v);
		
		return v;
		
	}
	
	public static ArrayList<Vol> trouverVolByVille(){
		
		System.out.println("entrez la ville de départ ");
		
		String d = sc.nextLine();
		
		System.out.println("entrez la ville d'arrivee");
		
		String a = sc.nextLine();
		
		ArrayList<Vol> l = (ArrayList<Vol>) VolDAO.getVolByVille(d, a);
		
		System.out.println(l);
		
		return l;
		
	}
	
	public static void gestionReservations() {
		
		System.out.println("1) création d'une réservation");
		System.out.println("2) voir toutes les réservations");
		System.out.println("3) voir les réservations d'un vol");
		System.out.println("4) annuler une réservation");
		System.out.println("5) voir toutes les réservations d'une personne");
		System.out.println("6) quitter");
		
		int choix = choix();
		
		switch(choix) {
			
			case 1:
					
				creerReservation();
				break;
				
			case 2:
				
				afficherReservations();
				break;
				
			case 3:
	
				afficherReservationsByVol();
				break;
				
			case 4:
	
				break;
				
			case 5:
				
				break;
				
			case 6:
				
				System.out.println("fin du programme");
				continuer = false;
				break;
				
			default:
				
				choixInconnu();
		
		}
		
	}
	
	public static void creerReservation() {
		
		System.out.println("saisir le numero de vol");
		
		String num = sc.nextLine();
		Vol v = VolDAO.getVolByNumber(num);
		
		System.out.println("entrez un nom");
		
		String n = sc.nextLine();
		
		System.out.println("entrez un prenom");
		
		String p = sc.nextLine();
		
		System.out.println("entrez un age");
		
		int a = Integer.parseInt(sc.nextLine());
		
		ReservationDAO.insererReservation(new Reservation(n,p,a,v));
		
	}
	
	public static void afficherReservations() {
		
		ArrayList<Reservation> l = (ArrayList<Reservation>) ReservationDAO.listeReservations();
		
		System.out.println("affichage des réservations");
		
		for(Reservation r : l) {
			System.out.println(r);
		}
		
	}
	
	public static void afficherReservationsByVol() {
		
		System.out.println("entrez le numéro du vol");
		
		String n = sc.nextLine();
		
		List<Reservation> l = ReservationDAO.getReservationsByVol(n);
		
		System.out.println("Réservations associees : ");
		
		for(Reservation r : l) {
			System.out.println(r);
		}
		
	}
	
	public static void annulerReservation(String num) {
		
		System.out.println("entrez le numéro de réservation");
		ReservationDAO.annulerReservation(num);
		System.out.println("Reservation annulee");
		
	}

}
