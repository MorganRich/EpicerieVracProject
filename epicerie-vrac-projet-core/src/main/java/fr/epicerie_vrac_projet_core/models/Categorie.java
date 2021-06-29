package fr.epicerie_vrac_projet_core.models;

import java.util.Set;
import java.util.TreeSet;

public class Categorie {
	private int id;
	private String nom;
	private Categorie surCategorie;
	private Set<Categorie> sousCategorie = new TreeSet<>();
	private Set<Article> articles = new TreeSet<>();
}
