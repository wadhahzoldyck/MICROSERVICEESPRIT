package esprit.microservice.microserviceplantexercice.controllers;

import esprit.microservice.microserviceplantexercice.Services.PlantService;
import esprit.microservice.microserviceplantexercice.clients.ExerciceClient;
import esprit.microservice.microserviceplantexercice.entities.PlantExercice;
import esprit.microservice.microserviceplantexercice.models.Exercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/PlantExercice")
public class PlantExerciceController {
    @Autowired
    private PlantService plantService;
    @Autowired
    private ExerciceClient exerciceClient;
    @GetMapping("/Getallplant")
    public ResponseEntity<List<PlantExercice>> GetallPlantExercie() {
        try {
            List<PlantExercice> plantExercices = plantService.GetallPlantExercie();

            if (plantExercices == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            for (PlantExercice plant : plantExercices) {
                List<Exercice>exercices=new ArrayList<>();
                for(Long i : plant.getListExercices())
                {
                    exercices.add(exerciceClient.findExerciceById(i));
                }
                plant.setExercices(exercices);
            }

            return new ResponseEntity<>(plantExercices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<PlantExercice> getPlantById(@PathVariable long id) {
        PlantExercice plant = plantService.GetPlantExerciebyeid(id);

        if (plant != null) {
            List<Exercice>exercices=new ArrayList<>();
            for(Long i : plant.getListExercices())
            {
                exercices.add(exerciceClient.findExerciceById(i));
            }
            plant.setExercices(exercices);
            return new ResponseEntity<>(plant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<PlantExercice> addPlant(@RequestBody PlantExercice plantExercice) {
        PlantExercice addedPlant = plantService.AddPlantExercie(plantExercice);
        return new ResponseEntity<>(addedPlant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PlantExercice> updatePlant(@RequestBody PlantExercice plantExercice) {
        PlantExercice updatedPlant = plantService.updatePlantExercie(plantExercice);

        if (updatedPlant != null) {
            return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlantById(@PathVariable long id) {
        boolean deleted = plantService.deletePlantExerciceById(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
