package tpAirFrance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		
		
		//afficherVols();
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
		System.out.println("3) quitter");
		int choix = choix();
		
		switch(choix) {
		
		case 1:
			
			creerVol();
			break;
			
		case 2:
			afficherVols();
			break;
			
		case 3:
			
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
		
		System.out.println("création d'un vol");
		
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
		
		Vol v = new Vol(ta,nbPlaces,villeD,villeA, d);
		
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

}
