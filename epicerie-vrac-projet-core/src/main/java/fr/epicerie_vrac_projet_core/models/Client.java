package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Client extends Personne {
	private String motDePasse;
	private Panier panier;
	private Set<Commande> commandes = new TreeSet<>();
	private Set<Article> favoris = new HashSet<>();
}
