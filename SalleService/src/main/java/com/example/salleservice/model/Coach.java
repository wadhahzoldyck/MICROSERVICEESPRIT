package com.example.salleservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Coach {

    long idCoach ;
    String nomCoach;
    String prenomCoach;
    String experiance;
    boolean availability;
}
