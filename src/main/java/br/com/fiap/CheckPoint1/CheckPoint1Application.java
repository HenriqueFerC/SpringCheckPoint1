package br.com.fiap.CheckPoint1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CheckPoint1Application {

	public static void main(String[] args) {
		SpringApplication.run(CheckPoint1Application.class, args);
	}

}
