package fr.formation.epicerievracprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.epicerievracprojet.models.Utilisateur;
import fr.formation.epicerievracprojet.repositories.UtilisateurRepository;

@RestController
public class AuthentificationController {
	
	@Autowired
	private UtilisateurRepository ur;
	
	@Autowired
	private PasswordEncoder pe;
	
	@PostMapping("/authentification")
	public Utilisateur authentification(@RequestParam String email, @RequestParam String password) {
		Utilisateur u = ur.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide"));
		if (!pe.matches(password, u.getPassword()))
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe invalide");
		return u;
		}
	}
