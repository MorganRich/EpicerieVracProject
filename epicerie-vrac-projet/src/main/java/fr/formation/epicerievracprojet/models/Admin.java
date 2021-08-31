package fr.formation.epicerievracprojet.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Admin extends Utilisateur {
	
	@NotBlank
	@NotNull
	@Length(min = 8)
	private String password;
	
}
