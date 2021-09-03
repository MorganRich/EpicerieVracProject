package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Integer> {

}
