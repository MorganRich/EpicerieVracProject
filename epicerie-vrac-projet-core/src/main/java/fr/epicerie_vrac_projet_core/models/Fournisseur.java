package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
public class Fournisseur extends Personne {
	
	private String nomEntreprise;
	private boolean producteur;
	private String description;
	
	@ManyToMany
	private Set<Article> articles = new HashSet<>();
	
}
