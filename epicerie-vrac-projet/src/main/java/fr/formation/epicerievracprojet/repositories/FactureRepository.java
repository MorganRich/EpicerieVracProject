package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

}
