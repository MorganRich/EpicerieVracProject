package fr.formation.epicerievracprojet.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
public class Personne {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private String nom;
	
	@NotBlank
	private String prenom;
	
	private String numeroTelephone;
	
	@OneToMany(mappedBy = "personne")
	private Set<Adresse> adresses = new HashSet<>();
	
}
