package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.epicerievracprojet.models.Client;
import fr.formation.epicerievracprojet.models.Commande;
import fr.formation.epicerievracprojet.models.Facture;
import fr.formation.epicerievracprojet.repositories.AdresseRepository;
import fr.formation.epicerievracprojet.repositories.ClientRepository;
import fr.formation.epicerievracprojet.repositories.CommandeRepository;
import fr.formation.epicerievracprojet.repositories.FactureRepository;
import fr.formation.epicerievracprojet.repositories.LigneAchatRepository;
import fr.formation.epicerievracprojet.repositories.PersonneRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private AdresseRepository ar;
	
	@Autowired
	private PersonneRepository pr;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private LigneAchatRepository lar;
	
	@Autowired
	private CommandeRepository cor;
	
	@Autowired
	private FactureRepository fr;
	
	@PreAuthorize("hasRole('ADMIN')")
	public Collection<Client> findAll() {
		return cr.findAll();
	}
	
	public Optional<Client> findById(int id) {
		System.out.println("service");
		return cr.findById(id);
	}
	
	@Transactional
	public void save(Client c) {
		c.setPassword(pe.encode(c.getPassword()));
		pr.save(c.getPersonne());
		cr.save(c);
		c.getPersonne().getAdresses().forEach(a -> {
			a.setPersonne(c.getPersonne());
			ar.save(a);
		});
		c.getPanier().setClient(c);
		c.getPanier().getArticles().forEach(a -> {
			a.getId().setAchat(c.getPanier());
			lar.save(a);
		});
	}
	
	@Transactional
	public void saveCommande(int id, Commande co) {
		Client c = cr.findById(id).get();
		
		cor.save(co);
		co.setNumeroCommande((int) Math.random() * 100000);
		co.setClient(c);
		co.getArticles().forEach(a -> {
			a.getId().setAchat(co);
			lar.save(a);
		});
		
		Facture f = new Facture();
		f.setNumeroFacture((int) Math.random() * 100000);
		f.setCommande(co);
		fr.save(f);
		
		//A FAIRE : Vider le panier dans la BDD
	}
	
	public void update(Client c) {
		cr.save(c);
	}
	
	public void delete(Client c) {
		cr.delete(c);
	}
	
	public void deleteById(int id) {
		cr.deleteById(id);
	}
	
}
