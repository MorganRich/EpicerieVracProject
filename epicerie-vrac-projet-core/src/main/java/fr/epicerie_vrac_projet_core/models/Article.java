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
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Article {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	@ToString.Include
	private int id;
	
	@ToString.Include
	private String reference;
	
	@ToString.Include
	private String nom;
	
	@ToString.Include
	private String image;
	
	@ToString.Include
	private String description;
	
	@ToString.Include
	private boolean bio;
	
	@ToString.Include
	private String lieuDeProduction;
	
	@ToString.Include
	private double prixUnitaire;
	
	@Enumerated(EnumType.STRING)
	@ToString.Include
	private UniteMesure uniteMesure;
	
	@ToString.Include
	private int pourcentagePromo;
	
	@ToString.Include
	private int quantiteEnStock;
	
	@ToString.Include
	private int nombreDeConsultation;
	
	@ManyToMany(mappedBy = "articles")
	private Set<Categorie> categories = new HashSet<>();
	
	@ManyToMany(mappedBy = "articles")
	private Set<Fournisseur> fournisseurs = new HashSet<>();
	
	@OneToMany(mappedBy ="id.article")
	private Set<LigneAchat> achats = new HashSet<>();

	public void calculerPrixTTC() {

	}
}
