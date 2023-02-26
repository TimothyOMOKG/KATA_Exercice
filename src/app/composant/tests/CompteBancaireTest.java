package app.composant.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.composant.CompteBancaire;

class CompteBancaireTest {
	

	@Test
	void testDeposer() {
		CompteBancaire compte = new CompteBancaire("Tim", "James");
		compte.deposer(2000.50); // on test que le solde a bien ete mis a jour (ajout)
		org.junit.jupiter.api.Assertions.assertEquals(compte.solde, 2000.5);
	}

	@Test
	void testRetrait() {
		CompteBancaire compte2 = new CompteBancaire("Tim", "James");
		compte2.deposer(2000.50);
		compte2.retrait(1500.50); // on test que le solde a bien ete mis a jour (ajout)
		org.junit.jupiter.api.Assertions.assertEquals(compte2.solde, 500.0);
	}
	


}
