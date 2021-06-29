package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;

public abstract class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String numeroTelephone;
	private Set<Adresse> adresses = new HashSet<>();
	
}
