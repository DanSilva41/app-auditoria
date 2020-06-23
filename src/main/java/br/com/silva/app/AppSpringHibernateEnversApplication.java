package br.com.silva.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppSpringHibernateEnversApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringHibernateEnversApplication.class, args);
    }

}
