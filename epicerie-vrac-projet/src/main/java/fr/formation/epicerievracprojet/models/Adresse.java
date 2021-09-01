package fr.formation.epicerievracprojet.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Adresse {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@Positive
	private int numero;
	
	@NotBlank
	private String typeDeVoie;
	
	private String complement;
	
	@NotBlank
	private String codePostal;
	
	@NotBlank
	private String ville;
	
	@ManyToOne
	@ToString.Exclude
	@JsonIgnore
	private Personne personne;
}
