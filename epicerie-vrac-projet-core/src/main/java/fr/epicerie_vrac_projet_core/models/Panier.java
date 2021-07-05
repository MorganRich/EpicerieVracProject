package fr.epicerie_vrac_projet_core.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
public class Panier extends Achat {
	
	@OneToOne
	private Client client;
	
}
