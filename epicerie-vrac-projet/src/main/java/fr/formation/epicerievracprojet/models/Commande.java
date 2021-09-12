package fr.formation.epicerievracprojet.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@ToString.Exclude
	@JsonIgnore
	private Client client;
	
	@OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
	private Facture facture;
	
}
