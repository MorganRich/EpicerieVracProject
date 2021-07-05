package fr.epicerie_vrac_projet_core.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.epicerie_vrac_projet_core.models.Achat;
import fr.epicerie_vrac_projet_core.models.Article;
import fr.epicerie_vrac_projet_core.models.LigneAchat;
import fr.epicerie_vrac_projet_core.models.Panier;
import fr.epicerie_vrac_projet_core.utils.HibernateUtil;

public class AchatRepository extends GenericRepository<Achat> {

	public AchatRepository() {
		super(Achat.class);
	}

	public void ajouterArticleAuPanier(Article a, Panier p, int quantite) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			ajouterArticleAuPanier(a, p, quantite, s);
		}
	}
	
	public void ajouterArticleAuPanier(Article a, Panier p, int quantite, Session s) {
		s.beginTransaction();
		ajouterArticleAuPanier(a, p, quantite, s, s.getTransaction());
		s.getTransaction().commit();
	}
	
	public void ajouterArticleAuPanier(Article a, Panier p, int quantite, Session s, Transaction t) {
		LigneAchat.LigneAchatId laId = new LigneAchat.LigneAchatId();
		laId.setAchat(p);
		laId.setArticle(a);
		LigneAchat la = new LigneAchat();
		la.setId(laId);
		la.setQuantite(quantite);
		s.save(la);
	}
	
}
