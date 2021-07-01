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
public class Adresse {
	@EqualsAndHashCode.Include
	private int id;
	private int numero;
	private String typeDeVoie;
	private String complement;
	private String codePostal;
	private String ville;
	private Personne personne;
}
