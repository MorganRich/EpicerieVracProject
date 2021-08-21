package fr.epicerie_vrac_projet_core.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epicerie_vrac_projet_core.models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	public Collection<Article> findByNomLike(String nom);
//		return s.createQuery("from Article where nom like :nom", Article.class)
//				.setParameter("nom", "%" + nom + "%")
//				.getResultList();
	
}
