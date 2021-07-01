package fr.epicerie_vrac_projet_core.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Panier extends Achat {
	private Client client;
	
}
