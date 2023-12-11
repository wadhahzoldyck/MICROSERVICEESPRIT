package esprit.microservice.microserviceplantexercice.entities;

import esprit.microservice.microserviceplantexercice.models.Exercice;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantExercice implements Serializable {
    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue
    private long idPlant;
    private String nomPlant;
    private LocalDate startPlant;
    private LocalDate endPlant;
    @ElementCollection
    private List<Long> listExercices;
    @Transient
    private List<Exercice>exercices;


}
