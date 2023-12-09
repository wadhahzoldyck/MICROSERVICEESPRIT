package com.example.salleservice.repository;

import com.example.salleservice.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SalleRepository extends JpaRepository<Salle,Long> {
}
