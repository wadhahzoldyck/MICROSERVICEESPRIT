package com.example.exercice.entity;

import com.example.exercice.entity.enumeration.CategoryEx;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

}
