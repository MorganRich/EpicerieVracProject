package fr.formation.epicerievracprojet.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
public abstract class Personne extends Utilisateur {
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	private String numeroTelephone;
	
	@OneToMany(mappedBy = "personne")
	private Set<Adresse> adresses = new HashSet<>();
	
}
