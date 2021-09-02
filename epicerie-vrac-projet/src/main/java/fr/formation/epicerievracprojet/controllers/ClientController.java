package fr.formation.epicerievracprojet.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.epicerievracprojet.models.Client;
import fr.formation.epicerievracprojet.models.Utilisateur;
import fr.formation.epicerievracprojet.repositories.UtilisateurRepository;
import fr.formation.epicerievracprojet.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService cs;
	
	@Autowired
	private UtilisateurRepository ur;
	
	@Autowired
	private PasswordEncoder pe;
	
	@GetMapping("")
	public Collection<Client> findAll() {
		return cs.findAll();
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable int id) {
		return cs.findById(id).get();
	}
	
	@PostMapping("")
	public void save(@RequestBody Client c) {
		cs.save(c);
	}
	
	@PostMapping("/admin")
	public void save(@RequestBody Utilisateur u) {
		u.setPassword(pe.encode(u.getPassword()));
		ur.save(u);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Client c) {
		cs.update(c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		cs.deleteById(id);
	}
	
}
