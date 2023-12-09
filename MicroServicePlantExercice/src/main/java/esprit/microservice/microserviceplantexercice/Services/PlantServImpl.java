package esprit.microservice.microserviceplantexercice.Services;

import esprit.microservice.microserviceplantexercice.Respository.PlantExRepository;
import esprit.microservice.microserviceplantexercice.entities.PlantExercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlantServImpl implements PlantService {
    @Autowired
    private  PlantExRepository plantExRepository;

    @Override
    public PlantExercice AddPlantExercie(PlantExercice newPlant) {
        return plantExRepository.save(newPlant);
    }

    @Override
    public PlantExercice updatePlantExercie(PlantExercice updatedPlant) {
        return plantExRepository.save(updatedPlant);
    }

    @Override
    public List<PlantExercice> GetallPlantExercie() {
        return plantExRepository.findAll();
    }

    @Override
    public PlantExercice GetPlantExerciebyeid(long idPlant) {
        return plantExRepository.findById(idPlant).orElseThrow(null);

    }

    @Override
    public boolean deletePlantExerciceById(long idPlant) {
        Optional<PlantExercice> optionalPlant = plantExRepository.findById(idPlant);

        if (optionalPlant.isPresent()) {
            plantExRepository.delete(optionalPlant.get());
            return true; // Indicate successful deletion
        } else {
            return false; // Indicate that the plant was not found
        }
    }


}
