package fr.epicerie_vrac_projet_core.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Commande extends Achat {
	
	private int numeroCommande;
	private LocalDate dateCommande;
	
	@ManyToOne
	private Client client;
	
	@OneToOne(mappedBy = "commande")
	private Facture facture;
	
}
