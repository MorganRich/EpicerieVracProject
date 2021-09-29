package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Achat;

@Repository
public interface AchatRepository extends JpaRepository<Achat, Integer> {

}
