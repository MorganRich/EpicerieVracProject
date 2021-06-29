package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Article {
	private int id;
	private String reference;
	private String nom;
	private String image;
	private String description;
	private boolean bio;
	private String lieuDeProduction;
	private double prixUnitaire;
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
