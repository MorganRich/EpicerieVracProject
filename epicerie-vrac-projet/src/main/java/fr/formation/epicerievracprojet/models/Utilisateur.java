package fr.formation.epicerievracprojet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	@NotNull
	@Length(min = 3)
	@Email
	@Column(unique = true)
	private String email;
	
	@NotBlank
	@NotNull
	@Length(min = 8)
	private String password;
	
	@NotBlank
	@NotNull
	private String role;
	
}
