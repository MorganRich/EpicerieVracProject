package fr.formation.epicerievracprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.formation.epicerievracprojet.repositories")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class EpicerieVracProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpicerieVracProjetApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	        	 registry.addMapping("/**")
					.allowedMethods("GET","POST","PUT","UPDATE","DELETE","OPTIONS")
					.allowedOrigins("http://localhost:4200");
	         }
	         
	         public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        	 registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	        	 }
		};
	}
	
	@Bean
	RouterFunction<ServerResponse> staticResourceLocator(Environment env){
		return RouterFunctions.resources("/files/**", new FileSystemResource(env.getProperty("epicerie-vrac.filepath")));
	}

}
