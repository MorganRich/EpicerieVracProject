package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;

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
public abstract class Personne {
	@EqualsAndHashCode.Include
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String numeroTelephone;
	private Set<Adresse> adresses = new HashSet<>();
	
}
