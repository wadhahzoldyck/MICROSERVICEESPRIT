package com.example.salleservice.clients;

import com.example.salleservice.model.Coach;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name="coach-service")
public interface CoachRestClient {

    @GetMapping("/coach/{idCoach}")
    @CircuitBreaker(name = "coachs", fallbackMethod = "getDefaultCoach")
    Coach findCoachById(@PathVariable long idCoach);
    @GetMapping("/coach/all")
    @CircuitBreaker(name = "coachs" , fallbackMethod = "getDefaultCoach1")
    List<Coach> allCoaches();

    default Coach getDefaultCoach(long idCoach, Throwable exception){
        Coach coach  = new Coach();
        coach.setIdCoach(idCoach);
        coach.setNomCoach("Not Available");
        coach.setPrenomCoach("Not Available");
        coach.setAvailability(false);
        coach.setExperiance("Not Available");
        return coach;

    }

    default List<Coach> getDefaultCoach1(){
       return new ArrayList<>();

    }

}
