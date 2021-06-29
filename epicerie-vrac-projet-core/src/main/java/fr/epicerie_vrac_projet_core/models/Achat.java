package fr.epicerie_vrac_projet_core.models;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Achat {
	private int id;
	private Set<LigneAchat> articles = new LinkedHashSet<>();
	
}
