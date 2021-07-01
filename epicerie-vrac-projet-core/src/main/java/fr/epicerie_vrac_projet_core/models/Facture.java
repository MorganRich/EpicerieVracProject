package fr.epicerie_vrac_projet_core.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Facture {
	@EqualsAndHashCode.Include
	private int id;
	private int numeroFacture;
	private Commande commande;
	
}
