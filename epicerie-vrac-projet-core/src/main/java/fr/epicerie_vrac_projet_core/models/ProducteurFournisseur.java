package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;

public class ProducteurFournisseur extends Personne {
	private String nomEntreprise;
	private String type;
	private String description;
	private Set<Article> articles = new HashSet<>();
	
}
