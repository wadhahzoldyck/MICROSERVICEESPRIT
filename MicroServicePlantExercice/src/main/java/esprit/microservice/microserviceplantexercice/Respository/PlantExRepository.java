package esprit.microservice.microserviceplantexercice.Respository;

import esprit.microservice.microserviceplantexercice.entities.PlantExercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantExRepository extends JpaRepository<PlantExercice,Long> {


}
