package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
