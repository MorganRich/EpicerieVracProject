package fr.formation.epicerievracprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.epicerievracprojet.services.FileService;

@RestController
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	private FileService fs;
	
	@GetMapping("/{nom}")
	public String findById(@PathVariable String nom) {
		return fs.getPath(nom).toString();
	}
	
}
