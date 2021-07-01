package fr.epicerie_vrac_projet_core.models;

import java.util.Set;
import java.util.TreeSet;

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
public class Categorie {
	@EqualsAndHashCode.Include
	private int id;
	private String nom;
	private Categorie surCategorie;
	private Set<Categorie> sousCategorie = new TreeSet<>();
	private Set<Article> articles = new TreeSet<>();
}
