package fr.epicerie_vrac_projet_core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epicerie_vrac_projet_core.models.Achat;

@Repository
public interface AchatRepository extends JpaRepository<Achat, Integer> {

//	public void ajouterArticleAuPanier(Article a, Panier p, int quantite) {
//		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
//			ajouterArticleAuPanier(a, p, quantite, s);
//		}
//	}
//	
//	public void ajouterArticleAuPanier(Article a, Panier p, int quantite, Session s) {
//		s.beginTransaction();
//		ajouterArticleAuPanier(a, p, quantite, s, s.getTransaction());
//		s.getTransaction().commit();
//	}
//	
//	public void ajouterArticleAuPanier(Article a, Panier p, int quantite, Session s, Transaction t) {
//		LigneAchat.LigneAchatId laId = new LigneAchat.LigneAchatId();
//		laId.setAchat(p);
//		laId.setArticle(a);
//		LigneAchat la = new LigneAchat();
//		la.setId(laId);
//		la.setQuantite(quantite);
//		s.save(la);
//	}
	
}
