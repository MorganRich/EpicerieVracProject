package fr.formation.epicerievracprojet.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
public class Fournisseur {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private String nomEntreprise;
	
	@NotBlank
	@NotNull
	@Length(min = 3)
	@Email
	@Column(unique = true)
	private String email;
	
	private boolean producteur;
	
	private String description;
	
	@OneToOne
	private Personne personne;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Article> articles = new HashSet<>();
	
}
