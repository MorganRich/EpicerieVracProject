package fr.epicerie_vrac_projet_core.models;

import java.time.LocalDate;

public class Commande extends Achat {
	private int numeroCommande;
	private LocalDate date;
	private double prixTotal;
	private Client client;
	private Facture facture;
	
	public void calculerPrixTotalTTC() {
		
	}
}
