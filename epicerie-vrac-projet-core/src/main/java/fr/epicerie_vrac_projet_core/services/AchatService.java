package fr.epicerie_vrac_projet_core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epicerie_vrac_projet_core.models.Article;
import fr.epicerie_vrac_projet_core.models.LigneAchat;
import fr.epicerie_vrac_projet_core.models.Panier;
import fr.epicerie_vrac_projet_core.repositories.LigneAchatRepository;

@Service
public class AchatService {

	@Autowired
	private LigneAchatRepository lar;
	
	public void ajouterArticleAuPanier(Article a, Panier p, int quantite) {
		LigneAchat.LigneAchatId laId = new LigneAchat.LigneAchatId();
		laId.setAchat(p);
		laId.setArticle(a);
		LigneAchat la = new LigneAchat();
		la.setId(laId);
		la.setQuantite(quantite);
		lar.save(la);
	}

}
