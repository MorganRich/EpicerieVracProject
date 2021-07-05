package fr.epicerie_vrac_projet_core;

import org.hibernate.Session;

import fr.epicerie_vrac_projet_core.models.Client;
import fr.epicerie_vrac_projet_core.models.Commande;
import fr.epicerie_vrac_projet_core.models.Panier;
import fr.epicerie_vrac_projet_core.repositories.ArticleRepository;
import fr.epicerie_vrac_projet_core.repositories.CategorieRepository;
import fr.epicerie_vrac_projet_core.repositories.ClientRepository;
import fr.epicerie_vrac_projet_core.repositories.CommandeRepository;
import fr.epicerie_vrac_projet_core.repositories.PanierRepository;
import fr.epicerie_vrac_projet_core.utils.HibernateUtil;

public class App {
	public static void main(String[] args) {

		ClientRepository cr = new ClientRepository();
		ArticleRepository ar = new ArticleRepository();
		CategorieRepository car = new CategorieRepository();
		PanierRepository pr = new PanierRepository();
		CommandeRepository cor = new CommandeRepository();

		/*Categorie c1 = new Categorie();
		c1.setNom("Alimentaire");
		car.save(c1);
		Categorie c2 = new Categorie();
		c2.setNom("Epicerie salé");
		c2.setSurCategorie(c1);
		car.save(c2);
		Categorie c3 = new Categorie();
		c3.setNom("Epicerie sucré");
		c3.setSurCategorie(c1);
		car.save(c3);
		Categorie c4 = new Categorie();
		c4.setNom("Boission");
		c4.setSurCategorie(c1);
		car.save(c4);*/
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			/*Article a1 = ar.findById(5, s).get();
			Article a2 = ar.findById(6, s).get();
			Article a3 = ar.findById(9, s).get();*/
			//Categorie c1 = car.findById(10, s).get();
			//c1.getSousCategorie().forEach(c -> System.out.println(c.getNom()));
			//System.out.println(c1);
			//Categorie c2 = car.findById(11, s).get();
			/*c1.getArticles().add(a1);
			c1.getArticles().add(a2);
			c1.getArticles().add(a3);
			c2.getArticles().add(a1);
			c2.getArticles().add(a2);
			c2.getArticles().add(a3);*/
			//System.out.println(c1);
			//System.out.println(c2);
			/*car.update(c1, s);
			car.update(c2, s);*/
			//System.out.println(car.findById(10, s));
			
			Client c = cr.findById(8, s).get();
			/*Panier p = new Panier();
			p.setClient(c);
			pr.save(p);
			Commande co = new Commande();
			co.setClient(c);
			co.setNumeroCommande(789123);
			co.setPrixTotal(100);
			cor.save(co);*/
			System.out.println(c.getCommandes());
			System.out.println(c.getPanier());
		}
		
		
		/*Client c = new Client();
		c.setNom("Villard");
		c.setPrenom("Marion");
		c.setEmail("mv@gmail.com");
		c.setMotDePasse("mv");
		c.setNumeroTelephone("0650...");

		cr.save(c);
		
		Article a = new Article();
		a.setReference("789123");
		a.setNom("Haricot");
		a.setBio(true);
		a.setPrixUnitaire(4);
		a.setUniteMesure(UniteMesure.KILO);

		ar.save(a);
		
		cr.findAll().forEach(System.out::println);
		ar.findAll().forEach(System.out::println);*/
		
		//Article a = ar.findById(3).get();
		//System.out.println(cr.findById(2));
		//a.setQuantiteEnStock(100);
		//ar.findByNameLike("a").forEach(System.out::println);
		
		//ar.update(a);
		
		//ar.delete(a);
		//ar.deleteById(a.getId());
		
		//Client c = cr.findByEmailAndPassword("mv@gmail.com", "mv").get();
		//c.setPrenom("Marion");
		//cr.update(c);
		
		//cr.delete(c);
		//cr.deleteById(cr.findById(1).get().getId());

	}
}
