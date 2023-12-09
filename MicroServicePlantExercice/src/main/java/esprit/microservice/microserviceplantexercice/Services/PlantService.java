package esprit.microservice.microserviceplantexercice.Services;

import esprit.microservice.microserviceplantexercice.Respository.PlantExRepository;
import esprit.microservice.microserviceplantexercice.entities.PlantExercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlantService {


public PlantExercice AddPlantExercie( PlantExercice  newPlant);
    public PlantExercice updatePlantExercie( PlantExercice  newPlant);
    public List<PlantExercice> GetallPlantExercie();
    public PlantExercice GetPlantExerciebyeid(long idPlant);
    public boolean deletePlantExerciceById(long idPlant);


}
