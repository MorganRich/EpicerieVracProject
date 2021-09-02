package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

}
