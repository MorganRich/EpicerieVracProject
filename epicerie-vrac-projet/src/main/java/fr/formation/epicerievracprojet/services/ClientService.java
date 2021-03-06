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
import fr.formation.epicerievracprojet.models.LigneAchat;
import fr.formation.epicerievracprojet.models.LigneAchat.LigneAchatId;
import fr.formation.epicerievracprojet.models.Panier;
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
		co.setNumeroCommande((int) Math.floor(Math.random() * 100000));
		co.setClient(c);
		co.getArticles().forEach(a -> {
			a.getId().setAchat(co);
			lar.save(a);
		});
		
		Facture f = new Facture();
		f.setNumeroFacture((int) Math.floor(Math.random() * 100000));
		f.setCommande(co);
		fr.save(f);
		
		c.getPanier().getArticles().forEach(a -> lar.delete(a));
	}
	
	public void updatePanier(int id, Panier p) {
		Client c = cr.findById(id).get();
		
		c.getPanier().getArticles().forEach(a -> lar.delete(a));
		if (!p.getArticles().isEmpty()) {
			c.getPanier().getArticles().clear();
			addArticlesPanier(c, p);
		}
	}
	
	@Transactional
	public void addArticlesPanier(Client c, Panier p) {
		c.getPanier().setPrixTotal(p.getPrixTotal());
		p.getArticles().forEach(a -> {
			LigneAchatId lai = new LigneAchatId();
			lai.setAchat(c.getPanier());
			lai.setArticle(a.getId().getArticle());
			LigneAchat la = new LigneAchat();
			la.setId(lai);
			la.setQuantite(a.getQuantite());
			lar.save(la);
		});
		cr.save(c);
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
