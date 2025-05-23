package org.zerock.sb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb2Application.class, args);
	}

}
