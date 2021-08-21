package fr.epicerie_vrac_projet_core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epicerie_vrac_projet_core.models.LigneAchat;
import fr.epicerie_vrac_projet_core.models.LigneAchat.LigneAchatId;

@Repository
public interface LigneAchatRepository extends JpaRepository<LigneAchat, LigneAchatId> {

}
