package com.example.exercice.clients;

import com.example.exercice.model.PlantExercice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "plant-service")
public interface PlantExerciceRestClient {
    @GetMapping("PlantExercice/get/{id}")
    @CircuitBreaker(name = "PlanSer", fallbackMethod = "getDefaultPlantExercice")
    PlantExercice getPlantById(@PathVariable long id);
    @GetMapping("PlantExercice/Getallplant")
    List<PlantExercice> GetallPlantExercie();
    default PlantExercice getDefaultPlantExercice(Long id,Throwable exception ){
        PlantExercice plantExercice=new PlantExercice();
        plantExercice.setIdPlant(id);
        plantExercice.setNomPlant("Not Vailable");
        return plantExercice;
    }
}
