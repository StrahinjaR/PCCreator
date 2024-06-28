package konfiguracija.racunara;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RacunaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacunaraApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseConnection(BazaTest databaseConnectionTest) {
		return args -> {
			databaseConnectionTest.testConnection();
		};

	}
}
