package com.example.coach.clients;

import com.example.coach.model.Salle;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name= "salle-service")
public interface SalleRestClient {
    @GetMapping("salle/{id}")
    @CircuitBreaker(name="salleService", fallbackMethod = "getDefaultSalle")
    Salle findSalleById(@PathVariable long id);
    @GetMapping("/salle/all")
    List<Salle> allSalles();
    default Salle getDefaultSalle(long id, Exception exception){
        Salle salle = new Salle();
        salle.setIdSalle(id);
        salle.setName("Not Vailable");
        salle.setLocation("Not Vailable");
        return salle;
    }
}
