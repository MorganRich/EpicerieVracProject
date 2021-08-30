package fr.formation.epicerievracprojet.models;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
public class Categorie {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private String nom;
	
	@ManyToOne
	@ToString.Exclude
	@JsonIgnore
	private Categorie surCategorie;
	
	@OneToMany(mappedBy ="surCategorie")
	private Set<Categorie> sousCategorie = new TreeSet<>();

	@ManyToMany
	private Set<Article> articles = new TreeSet<>();

}
