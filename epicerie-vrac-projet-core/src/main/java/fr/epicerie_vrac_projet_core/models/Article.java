package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	private String reference;
	
	private String nom;
	
	private String image;
	
	private String description;
	
	private boolean bio;
	
	private String lieuDeProduction;
	
	private double prixUnitaire;
	
	@Enumerated(EnumType.STRING)
	private UniteMesure uniteMesure;
	
	private int pourcentagePromo;
	
	private int quantiteEnStock;
	
	private int nombreDeConsultation;
	
	@ManyToMany(mappedBy = "articles")
	@ToString.Exclude
	private Set<Categorie> categories = new HashSet<>();
	
	@ManyToMany(mappedBy = "articles")
	@ToString.Exclude
	private Set<Fournisseur> fournisseurs = new HashSet<>();
	
	@OneToMany(mappedBy ="id.article")
	private Set<LigneAchat> achats = new HashSet<>();

	public void calculerPrixTTC() {

	}
}
