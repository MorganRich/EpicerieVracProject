package fr.formation.epicerievracprojet.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString()
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Facture {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private int numeroFacture;
	
	@OneToOne
	private Commande commande;
	
}