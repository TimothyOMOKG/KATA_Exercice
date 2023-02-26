package app.composant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CompteBancaire {
	static Scanner scan;
	// création d'une énumération opération pour définir l'opération qu'on souhaite réaliser
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
	public ArrayList <String> history= new ArrayList<String>(); // ArrayList pour gérer l'historique des transactions bancaires
	
	public CompteBancaire(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		// TODO Auto-generated constructor stub
	}
	
	
}
