package esprit.microservice.microserviceplantexercice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroServicePlantExerciceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicePlantExerciceApplication.class, args);
    }

}
