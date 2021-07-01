package fr.epicerie_vrac_projet_core.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Commande extends Achat {
	private int numeroCommande;
	private LocalDate date;
	private double prixTotal;
	private Client client;
	private Facture facture;
	
	public void calculerPrixTotalTTC() {
		
	}
}
