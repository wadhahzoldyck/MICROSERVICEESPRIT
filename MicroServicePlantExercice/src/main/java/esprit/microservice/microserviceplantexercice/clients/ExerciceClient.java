package esprit.microservice.microserviceplantexercice.clients;

import esprit.microservice.microserviceplantexercice.models.Exercice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "exercice-service")
public interface ExerciceClient {
    @GetMapping("/Exercice/{id}")
    @CircuitBreaker(name = "exeserv",fallbackMethod = "getDefaultExercice")
    Exercice findExerciceById(@PathVariable Long id);
    @GetMapping("/Exercice")
    List<Exercice> findExercices();
default Exercice getDefaultExercice(Long id,Exception exception)
{
    Exercice defaultEx=new Exercice();
    defaultEx.setIdExercice(id);
    defaultEx.setNomExercice("Not available");
    return defaultEx;

}
}
