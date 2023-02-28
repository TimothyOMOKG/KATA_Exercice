package app.composant;

import java.util.Scanner;

public class MenuCliCompteBancaire {
	
	static Scanner scan; // appel de la fonction scanner
	
	static void menu() {
		int value = 0;
		boolean id1 = false;
		while (true) 
			if(id1==false) {
			System.out.println("Votre nom :");
			String nom = scan.nextLine();
			System.out.println("Votre prenom :");
			String prenom = scan.nextLine();
			CompteBancaire compte = new CompteBancaire(nom, prenom); 
			id1 = true;
			
			do {
			System.out.println("\n***** Bonjour "+nom+" "+prenom+", bienvenue sur votre Banque CLI KATA *****");
			System.out.println("Depot (1), Retrait (2)  Consulter l'historique du compte (3) Quitter (4)");
			System.out.print("Choix ? :");
			value = Integer.parseInt(scan.nextLine());
			switch (value) {
			case 1: {
				try {
					double transac = nouvelleTransactionDepot();
					compte.deposer(transac);
					System.out.println("Votre depot a ete effectue ! \n");
				} catch (Exception e) {
					System.out.println("Erreur de saisi");
				}
				break;

			}
			case 2: {
				try {
					double transac = nouvelleTransactionRetrait();
					compte.retrait(transac);
					System.out.println("Votre retrait a ete effectue ! \n");
				} catch (Exception e) {
					System.out.println("Erreur de saisi");
				}
				break;
			}
			case 3: {

				try {
					compte.affichHisto();
				} catch (Exception e) {
					System.out.println("Erreur de saisi");
				}
				break;
			}
			case 4: {

				try {
					System.out.println("**********  Merci de votre visite au revoir  ***************\n");
					id1 = false;

				} catch (Exception e) {
					System.out.println("Erreur de saisi");
				}
				break;
			}
			default:
				System.out.println("Unexpected value: " + value + "\n" + "veuiller saisir un chiffre entre 1 et 4 ");
			}
			
			} while(id1 == true);

	}
		}
	
	
	public static double nouvelleTransactionDepot() {
		double depot;
		scan = new Scanner(System.in);
		System.out.println("\n--- Vous allez effectuer un depot --- \n");
		// Presentation de l'interface CLI
		System.out.println("Montant du depot : ");
		depot = Double.parseDouble(scan.nextLine());
		return depot;
	}
	
	public static double nouvelleTransactionRetrait() {
		scan = new Scanner(System.in);
		System.out.println("\n-- Vous allez effectuer un retrait \n");
		// Presentation de l'interface CLI
		System.out.println("Montant du retrait :\n");
		double retrait = Double.parseDouble(scan.nextLine());
		return retrait;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		menu();
		
	}
}
