package com.example.coach;

import com.example.coach.entities.Coach;
import com.example.coach.repository.CoachRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoachApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CoachRepository coachRepository){
		return args -> {
			Coach coach1=
			Coach.builder()
							.nomCoach("oussema")
							.prenomCoach("amri")
							.experiance("3 ans")
							.availability(true)
					.build();
			coachRepository.save(coach1);
		};
	}

}
