package com.example.exercice.entity;

import com.example.exercice.entity.enumeration.CategoryEx;
import com.example.exercice.model.PlantExercice;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idExercice;
    String nomExercice;
    String descriptionEx;
    @Enumerated(EnumType.STRING)
    CategoryEx categoryEx;

    @Transient
    private List<PlantExercice> listPlantExercice;
    @ElementCollection
    private List<Long> listPlantExercices;

}
