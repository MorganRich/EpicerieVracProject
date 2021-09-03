package fr.formation.epicerievracprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.LigneAchat;
import fr.formation.epicerievracprojet.models.LigneAchat.LigneAchatId;

@Repository
public interface LigneAchatRepository extends JpaRepository<LigneAchat, LigneAchatId> {

}
