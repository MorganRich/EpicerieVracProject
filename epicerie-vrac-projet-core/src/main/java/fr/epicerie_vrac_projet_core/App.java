package fr.epicerie_vrac_projet_core;

import fr.epicerie_vrac_projet_core.models.Article;
import fr.epicerie_vrac_projet_core.models.Client;
import fr.epicerie_vrac_projet_core.models.UniteMesure;
import fr.epicerie_vrac_projet_core.repositories.ArticleRepository;
import fr.epicerie_vrac_projet_core.repositories.ClientRepository;

public class App {
	public static void main(String[] args) {

		ClientRepository cr = new ClientRepository();
		ArticleRepository ar = new ArticleRepository();

		Client c = new Client();
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
		ar.findAll().forEach(System.out::println);
		
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
