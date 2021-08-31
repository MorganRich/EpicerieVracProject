package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.formation.epicerievracprojet.models.Admin;
import fr.formation.epicerievracprojet.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository ar;
	
	@PreAuthorize("hasRole('ADMIN')")
	public Collection<Admin> findAll() {
		return ar.findAll();
	}
	
	public Optional<Admin> findById(int id) {
		return ar.findById(id);
	}
	
	public Optional<Admin> findByEmail(String email) {
		return ar.findByEmail(email);
	}
	
	public void save(Admin a) {
		ar.save(a);
	}
	
	public void update(Admin a) {
		ar.save(a);
	}
	
	public void delete(Admin a) {
		ar.delete(a);
	}
	
	public void deleteById(int id) {
		ar.deleteById(id);
	}
	
}
