package fr.epicerie_vrac_projet_core.repositories;

import java.util.Optional;

import org.hibernate.Session;

import fr.epicerie_vrac_projet_core.models.Article;
import fr.epicerie_vrac_projet_core.utils.HibernateUtil;

public class ArticleRepository extends GenericRepository<Article> {

	public ArticleRepository() {
		super(Article.class);
	}

	public Optional<Article> findByNameLike(String name) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return findByNameLike(name, s);
		}
	}
	
	public Optional<Article> findByNameLike(String name, Session s) {
		return Optional.ofNullable(s.createQuery("from Article where nom like :name", Article.class)
				.setParameter("name", "%" + name + "%")
				.getSingleResult());
	}
	
}
