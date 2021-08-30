package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
