package fr.formation.epicerievracprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.epicerievracprojet.models.Admin;
import fr.formation.epicerievracprojet.models.Client;
import fr.formation.epicerievracprojet.models.Utilisateur;
import fr.formation.epicerievracprojet.repositories.UtilisateurRepository;
import fr.formation.epicerievracprojet.services.AdminService;
import fr.formation.epicerievracprojet.services.ClientService;

@RestController
public class AuthentificationController {

	@Autowired
	private ClientService cs;
	
	@Autowired
	private AdminService as;
	
	@Autowired
	private UtilisateurRepository ur;
	
	@Autowired
	private PasswordEncoder pe;
	
	@PostMapping("/authentification")
	public Utilisateur authentification(@RequestParam String email, @RequestParam String password) {
		Utilisateur u = ur.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide"));
		if (u.getRole().contains("ROLE_CLIENT")) {
			Client c = cs.findById(u.getId()).get();
			if (!pe.matches(password, c.getPassword()))
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide");
			return c;
		}
		else {
			Admin a = as.findById(u.getId()).get();
			if (!pe.matches(password, a.getPassword()))
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide");
			return a;
		}
	}
	
}
