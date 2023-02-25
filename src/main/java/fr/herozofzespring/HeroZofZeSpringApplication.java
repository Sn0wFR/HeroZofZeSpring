package fr.herozofzespring;

import fr.herozofzespring.adapter.rest.HeroController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("fr")
@EnableWebMvc
public class HeroZofZeSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroZofZeSpringApplication.class, args);
    }

}
