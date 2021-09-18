package fr.formation.epicerievracprojet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import fr.formation.epicerievracprojet.models.Utilisateur;
import fr.formation.epicerievracprojet.repositories.UtilisateurRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UtilisateurRepository ur;
	
	private final RequestMatcher ALLOWED_URL = new OrRequestMatcher(
			new AntPathRequestMatcher("/authentification", "POST"),
			new AntPathRequestMatcher("/clients", "POST"),
			new AntPathRequestMatcher("/articles", "GET"),
			new AntPathRequestMatcher("/articles/**", "GET"),
			new AntPathRequestMatcher("/articles/*/upConsultation", "PUT"),
			new AntPathRequestMatcher("/files/**", "GET"),
			new AntPathRequestMatcher("/assets/**", "GET"),
			new AntPathRequestMatcher("/fournisseurs", "GET"),
			new AntPathRequestMatcher("/fournisseurs/**", "GET"));
	
	private final RequestMatcher AUTHENTICATED_URL = new OrRequestMatcher(
			new AntPathRequestMatcher("/clients/**", "GET"),
			new AntPathRequestMatcher("/clients/panier/**", "POST"),
			new AntPathRequestMatcher("/clients/commande/**", "POST"),
			new AntPathRequestMatcher("/clients/**", "PUT"),
			new AntPathRequestMatcher("/clients/**", "DELETE"));
	
	private final RequestMatcher ADMIN_URL = new OrRequestMatcher(
			new AntPathRequestMatcher("/clients", "GET"),
			new AntPathRequestMatcher("/clients/admin", "POST"),
			new AntPathRequestMatcher("/articles/categories", "POST"),
			new AntPathRequestMatcher("/articles", "POST"),
			new AntPathRequestMatcher("/articles/**", "PUT"),
			new AntPathRequestMatcher("/articles/**", "DELETE"),
			new AntPathRequestMatcher("/fournisseurs", "POST"),
			new AntPathRequestMatcher("/fournisseurs/**", "PUT"),
			new AntPathRequestMatcher("/fournisseurs/**", "DELETE"));
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return (email) -> {
			Utilisateur u = ur.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("aucun utilisateur avec l'email " + email));
			return new User(u.getEmail(), u.getPassword(), AuthorityUtils.createAuthorityList(u.getRole()));
		};
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().formLogin().disable()
			.logout().disable()
			.csrf().disable()
			.authorizeRequests()
				.requestMatchers(ALLOWED_URL).permitAll()
				.requestMatchers(AUTHENTICATED_URL).authenticated()
				.requestMatchers(ADMIN_URL).access("hasRole('ADMIN')")
				.antMatchers("/**").denyAll()
			.and().cors()
			.and().httpBasic();
				
	}

	
	
}
