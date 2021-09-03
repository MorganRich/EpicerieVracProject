package fr.formation.epicerievracprojet.models;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Client extends Utilisateur {
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	@Where(clause = "DTYPE = 'Panier'")
	private Panier panier;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@Where(clause = "DTYPE = 'Commande'")
	private Set<Commande> commandes = new TreeSet<>();
	
	@ManyToMany
	private Set<Article> favoris = new HashSet<>();
	
	@OneToOne
	private Personne personne;
}
