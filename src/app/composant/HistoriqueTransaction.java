package app.composant;

public class HistoriqueTransaction extends CompteBancaire {
	
	// Classe qui va permettre l'affichage de l'historique bancaire à partir des informations qu'on lui aura données
	protected String date;
	protected String operation;
	protected String solde = "0";
	protected String transaction;


	
	
	public HistoriqueTransaction(String nom, String prenom, String date, String operation, String transaction, String solde) {
		super(nom, prenom);
		this.date = date;
		this.operation = operation;
		this.solde = solde; 
		this.transaction = transaction;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		
		return ""+super.toString()+" votre solde est de :" + this.solde +"€"+"\n"+"votre dernère transaction fait le "+" "+this.date+ " "+this.operation+":"+" "+this.transaction+"\n";
	}
	
	

}
