package com.example.salleservice;

import com.example.salleservice.Entities.Salle;
import com.example.salleservice.repository.SalleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class SalleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalleServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SalleRepository salleRepository){
		return  args -> {

		List<Salle> Salles =	List.of(
				Salle.builder()
						.name("CaliforniaGym")
						.Location("tunisie")
						.capacity(120)
						.idCoach(Arrays.asList(1L))
						.build() ,
				Salle.builder()
						.name("CACTUS")
						.Location("tunisie")
						.capacity(500)
						.idCoach(Arrays.asList(2L))
						.build()
		);


			salleRepository.saveAll(Salles);
		};
	}
}
