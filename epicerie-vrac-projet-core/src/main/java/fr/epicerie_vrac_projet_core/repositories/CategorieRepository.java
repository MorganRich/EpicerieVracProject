package fr.epicerie_vrac_projet_core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epicerie_vrac_projet_core.models.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
