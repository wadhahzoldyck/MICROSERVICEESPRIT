package com.example.salleservice.Entities;

import com.example.salleservice.model.Coach;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle ;
    private String name ;
    private String Location ;

    private int capacity ;

    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    Blob image;
    @Transient
     private Coach coach ;
    @ElementCollection
    private List<Integer> idCoach ;

}
