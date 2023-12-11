package com.example.salleservice.services;

import com.example.salleservice.Entities.Salle;
import com.example.salleservice.repository.SalleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ISalleServiceImp implements ISalleService{

    private final SalleRepository salleRepository;
    @Override
    public Salle addSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public List<Salle> retrieveSalles() {
        return salleRepository.findAll();
    }

    @Override
    public Salle updateSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public Salle retrieveSalleById(long idSalle) {
        return salleRepository.findById(idSalle).orElseThrow(()->new IllegalArgumentException("No Salle Found"));
    }

    @Override
    public void removeSalle(long idSalle) {
        salleRepository.deleteById(idSalle);
    }
}
