package fr.formation.epicerievracprojet.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private int numeroFacture;
	
	@OneToOne
	@JsonIgnore
	private Commande commande;
	
}
