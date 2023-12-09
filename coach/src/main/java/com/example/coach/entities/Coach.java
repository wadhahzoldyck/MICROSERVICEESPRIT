package com.example.coach.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
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
}
