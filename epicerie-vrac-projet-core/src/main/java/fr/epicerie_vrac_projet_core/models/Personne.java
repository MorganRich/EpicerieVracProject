package fr.epicerie_vrac_projet_core.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString()
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String numeroTelephone;
	
	@OneToMany(mappedBy = "personne")
	@ToString.Exclude
	private Set<Adresse> adresses = new HashSet<>();
	
}
