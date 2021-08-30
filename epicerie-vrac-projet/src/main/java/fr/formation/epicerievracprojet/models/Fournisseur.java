package fr.formation.epicerievracprojet.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank
	private String nomEntreprise;
	
	private boolean producteur;
	
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Article> articles = new HashSet<>();
	
}
