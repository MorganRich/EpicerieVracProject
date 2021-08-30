package fr.epicerie_vrac_projet_core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import fr.epicerie_vrac_projet_core.models.Article;
import fr.epicerie_vrac_projet_core.models.Client;
import fr.epicerie_vrac_projet_core.repositories.ArticleRepository;
import fr.epicerie_vrac_projet_core.repositories.CategorieRepository;
import fr.epicerie_vrac_projet_core.repositories.ClientRepository;
import fr.epicerie_vrac_projet_core.services.AchatService;

@Configuration
@ComponentScan(basePackages = "fr.epicerie_vrac_projet_core")
@EnableAspectJAutoProxy
public class App {

	public static void main(String[] args) {

		try (var ac = new AnnotationConfigApplicationContext(App.class)) {
			ClientRepository cr = ac.getBean(ClientRepository.class);
			ArticleRepository ar = ac.getBean(ArticleRepository.class);
			CategorieRepository car = ac.getBean(CategorieRepository.class);
			AchatService as = ac.getBean(AchatService.class);

			/*
			 * Categorie c1 = new Categorie(); c1.setNom("Alimentaire"); car.save(c1);
			 * Categorie c2 = new Categorie(); c2.setNom("Epicerie salé");
			 * c2.setSurCategorie(c1); car.save(c2); Categorie c3 = new Categorie();
			 * c3.setNom("Epicerie sucré"); c3.setSurCategorie(c1); car.save(c3); Categorie
			 * c4 = new Categorie(); c4.setNom("Boission"); c4.setSurCategorie(c1);
			 * car.save(c4);
			 */

			// Article a1 = ar.findById(5, s).get();
			// Article a2 = ar.findById(6, s).get();
			Article a3 = ar.findById(7).get();
			// Categorie c1 = car.findById(10, s).get();
			// c1.getSousCategorie().forEach(c -> System.out.println(c.getNom()));
			// a3.getAchats().forEach(ligne ->
			// System.out.println(ligne.getId().getAchat().getId() + " " +
			// ligne.getId().getArticle().getId()));
			// Categorie c2 = car.findById(11, s).get();
			/*
			 * c1.getArticles().add(a1); c1.getArticles().add(a2); c1.getArticles().add(a3);
			 * c2.getArticles().add(a1); c2.getArticles().add(a2); c2.getArticles().add(a3);
			 */
			// System.out.println(c1);
			// System.out.println(c2);
			/*
			 * car.update(c1, s); car.update(c2, s);
			 */
			// System.out.println(car.findById(10, s));

			/*
			 * Client c = new Client(); c.setNom("Richard"); c.setPrenom("Morgan");
			 * c.setEmail("mr@gmail.com"); c.setMotDePasse("mr");
			 * c.setNumeroTelephone("0625...");
			 * 
			 * cr.save(c);
			 */

			Client c = cr.findById(8).get();
//			System.out.println(c.getPanier());
			as.ajouterArticleAuPanier(a3, c.getPanier(), 100);
//			System.out.println(c.getPanier().getArticles());

			/*
			 * LigneAchat.LigneAchatId laId = new LigneAchat.LigneAchatId();
			 * laId.setAchat(acr.findById(15, s).get()); laId.setArticle(a3); LigneAchat la
			 * = new LigneAchat(); la.setId(laId); la.setQuantite(10);
			 * 
			 * lar.save(la);
			 */

			// System.out.println(acr.findById(15, s).get());
			// c2.getPanier().getArticles().add(la);
			/*
			 * Panier p = new Panier(); p.setClient(c); acr.save(p);
			 */
			/*
			 * Commande co = new Commande(); co.setClient(c); co.setNumeroCommande(789123);
			 * co.setPrixTotal(100); cor.save(co);
			 */
			// System.out.println(c.getCommandes());
			// System.out.println(c.getPanier());
			// c.getFavoris().add(a1);
			// cr.update(c, s);

			// System.out.println(c2.getPanier().getArticles());
			// c2.getPanier().getArticles().forEach(ligne ->
			// System.out.println(ligne.getId().getAchat().getId() + " " +
			// ligne.getId().getArticle().getId()));

			/*
			 * Article a = new Article(); a.setReference("789123"); a.setNom("Haricot");
			 * a.setBio(true); a.setPrixUnitaire(4); a.setUniteMesure(UniteMesure.KILO);
			 */

			// ar.save(a);

			/*
			 * cr.findAll().forEach(System.out::println);
			 * ar.findAll().forEach(System.out::println);
			 */

			// Article a = ar.findById(3).get();
			// System.out.println(cr.findById(2));
			// a.setQuantiteEnStock(100);
			// ar.findByNameLike("a").forEach(System.out::println);

			// ar.update(a);

			// ar.delete(a);
			// ar.deleteById(a.getId());

			// Client c = cr.findByEmailAndPassword("mv@gmail.com", "mv").get();
			// c.setPrenom("Marion");
			// cr.update(c);

			// cr.delete(c);
			// cr.deleteById(cr.findById(1).get().getId());
		}
	}
}
