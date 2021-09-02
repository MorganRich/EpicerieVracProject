package fr.formation.epicerievracprojet.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
public class Article {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private String reference;
	
	@NotBlank
	private String nom;
	
	private String image;
	
	private String description;
	
	private boolean bio;
	
	private String lieuDeProduction;
	
	@Positive
	private double prixUnitaire;
	
	@Enumerated(EnumType.STRING)
	private UniteMesure uniteMesure;
	
	@PositiveOrZero
	private int pourcentagePromo;
	
	@PositiveOrZero
	private int quantiteEnStock;
	
	@PositiveOrZero
	private int nombreDeConsultation;
	
	@ManyToMany(mappedBy = "articles", cascade = CascadeType.ALL)
	private Set<Categorie> categories = new HashSet<>();
	
	@ManyToMany(mappedBy = "articles")
	@ToString.Exclude
	@JsonIgnore
	private Set<Fournisseur> fournisseurs = new HashSet<>();
	
	@OneToMany(mappedBy ="id.article")
	@JsonIgnore
	private Set<LigneAchat> achats = new HashSet<>();

}
