package fr.formation.epicerievracprojet.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank
	private int numeroCommande;
	
	@NotBlank
	private LocalDate dateCommande;
	
	@ManyToOne
	@ToString.Exclude
	@JsonIgnore
	private Client client;
	
	@OneToOne(mappedBy = "commande")
	private Facture facture;
	
}
