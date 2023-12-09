package com.example.salleservice.repository;

import com.example.salleservice.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface SalleRepository extends JpaRepository<Salle,Long> {
}
