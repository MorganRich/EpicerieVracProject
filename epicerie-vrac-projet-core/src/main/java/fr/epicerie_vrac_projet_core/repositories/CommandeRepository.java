package fr.epicerie_vrac_projet_core.repositories;

import fr.epicerie_vrac_projet_core.models.Commande;

public class CommandeRepository extends GenericRepository<Commande> {

	public CommandeRepository() {
		super(Commande.class);
	}

}
