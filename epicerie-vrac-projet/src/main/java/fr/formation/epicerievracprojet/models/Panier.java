package fr.formation.epicerievracprojet.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Panier extends Achat {
	
	@ToString.Exclude
	@JsonIgnore
	@OneToOne
	private Client client;
	
}
