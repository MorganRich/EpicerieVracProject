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
public class Article {
	@EqualsAndHashCode.Include
	private int id;
	private String reference;
	private String nom;
	private String image;
	private String description;
	private boolean bio;
	private String lieuDeProduction;
	private double prixUnitaire;
	private UniteMesure uniteMesure;
	private int pourcentagePromo;
	private int quantiteEnStock;
	private int nombreDeConsultation;
	private Set<Categorie> categories = new HashSet<>();
	private ProducteurFournisseur producteur;
	private Set<ProducteurFournisseur> fournisseurs = new HashSet<>();
	private Set<LigneAchat> achats = new HashSet<>();

	public void calculPrixTTC() {

	}
}
