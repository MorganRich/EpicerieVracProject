package fr.epicerie_vrac_projet_core.repositories;

import fr.epicerie_vrac_projet_core.models.Facture;

public class FactureRepository extends GenericRepository<Facture> {

	public FactureRepository() {
		super(Facture.class);
	}

}
