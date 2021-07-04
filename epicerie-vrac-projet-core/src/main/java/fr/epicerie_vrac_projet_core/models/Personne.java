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
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	@ToString.Include
	private int id;
	
	@ToString.Include
	private String nom;
	
	@ToString.Include
	private String prenom;
	
	@ToString.Include
	private String email;
	
	@ToString.Include
	private String numeroTelephone;
	
	@OneToMany(mappedBy = "personne")
	private Set<Adresse> adresses = new HashSet<>();
	
}
