package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}
