package fr.epicerie_vrac_projet_core.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class LigneAchat {
	private int quantite;
	private Article article;
	private Achat achat;
	
	public void calculerTotalLigne() {
		
	}
}
