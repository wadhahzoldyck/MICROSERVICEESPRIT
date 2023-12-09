package com.example.salleservice.services;

import com.example.salleservice.Entities.Salle;

import java.util.List;

public interface ISalleService {
    Salle addSalle (Salle salle);
    List<Salle> retrieveSalles();
    Salle updateSalle(Salle salle);
    Salle retrieveSalleById(long idSalle);

    void removeSalle(long idSalle);


}
