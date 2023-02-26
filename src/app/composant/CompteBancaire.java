package app.composant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CompteBancaire {
	static Scanner scan;
	// cr�ation d'une �num�ration op�ration pour d�finir l'op�ration qu'on souhaite r�aliser
	public enum Operation {
		Depot, Retrait
	}
	// attributs du compte bancaire : nom, prenom, solde, retrait, depot, decouvert, date 
	private String nom;
	private String prenom;
	public double solde=0;
	public double depot;
	public double retrait;
	public double decouvert;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // gestion de la date 
	private LocalDateTime date = LocalDateTime.now(); ;
	public ArrayList <String> history= new ArrayList<String>(); // ArrayList pour g�rer l'historique des transactions bancaires
	
	public CompteBancaire(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		// TODO Auto-generated constructor stub
	}
	
	// gestion du d�pot de l'argent
	public void deposer(double depot) {
		date = LocalDateTime.now();
		this.solde = this.solde + depot;
		Operation deposer = Operation.Depot;
		HistoriqueTransaction histo = new HistoriqueTransaction(this.nom, this.prenom, this.dateFormat.format(date), deposer.toString(),
				String.valueOf(depot), String.valueOf(this.solde));
		history.add(histo.toString());
	}
	
	// gestion du retrait de l'argent ; On aurait pu faire avec un switch case ; 
	public void retrait(double retrait) {
		date = LocalDateTime.now();
		if (this.solde > retrait) {
			this.solde = this.solde - retrait;
			Operation retirer = Operation.Retrait;
			HistoriqueTransaction histo = new HistoriqueTransaction(this.nom, this.prenom, this.dateFormat.format(date),
					retirer.toString(), String.valueOf(retrait), String.valueOf(this.solde));
			history.add(histo.toString());
		} else if (this.solde < retrait) {
			this.solde = this.solde - retrait;
			this.decouvert = solde;
			Operation retirer = Operation.Retrait;
			HistoriqueTransaction histo = new HistoriqueTransaction(this.nom, this.prenom, this.dateFormat.format(date),
					retirer.toString(), String.valueOf(retrait),String.valueOf(this.solde));
			history.add(histo.toString());
			System.out.println(
					"Vous �tes en d�couvert votre compte est maintenant d�biteur de : " + Math.abs(this.decouvert));
		} else if (this.solde == retrait) {
			this.solde = this.solde - retrait;
			this.decouvert = solde;
			Operation retirer = Operation.Retrait;
			HistoriqueTransaction histo = new HistoriqueTransaction(this.nom, this.prenom, this.dateFormat.format(date),
					retirer.toString(), String.valueOf(retrait),String.valueOf(this.solde));
			history.add(histo.toString());
			System.out.println("votre compte est de 0 � : " + Math.abs(this.decouvert));
		}
	}
	// cr�ation d'une m�thode toString pour la gestion de l'affichage CLI
	public String toString()
	
	{
		return "********************* Historique**********************\n"+"\t"+" Bonjour "+this.nom+ " "+this.prenom+"\n";
	}

	// m�thode qui va afficher sous forme de string l'historique du compte bancaire 
	public void affichHisto() {
		if(history.isEmpty()) {
			history.add("********************* Historique**********************\n"+"\t"+" Bonjour "+this.nom+ " "+this.prenom+"\n"+
					"votre solde est de :"+ this.solde+" �"+" "+this.dateFormat.format(date)+"\n");
			System.out.println(history.toString());
		}else {
		System.out.println(history.toString());
		}
	}
	
}
