package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
public class Client extends Personne {
	
	@ToString.Include
	private String motDePasse;
	
	@OneToOne(mappedBy = "client")
	private Panier panier;
	
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes = new TreeSet<>();
	
	@ManyToMany
	private Set<Article> favoris = new HashSet<>();
}
