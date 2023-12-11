package com.example.coach.entities;

import com.example.coach.model.Salle;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCoach ;
    String nomCoach;
    String prenomCoach;
    String experiance;
    boolean availability;
    @Transient
    Salle salle;
    long salleId;
}
