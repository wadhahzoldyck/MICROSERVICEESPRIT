package com.example.salleservice.controllers;

import com.example.salleservice.Entities.Salle;
import com.example.salleservice.services.ISalleServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salle")
@CrossOrigin(origins = "*")
@Slf4j
@AllArgsConstructor
public class SalleRestController {
    private final ISalleServiceImp iSalleServiceImp;

    @PostMapping
    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle) {
        Salle addedSalle = iSalleServiceImp.addSalle(salle);
        return new ResponseEntity<>(addedSalle, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) {
        Salle updatedSalle = iSalleServiceImp.updateSalle(salle);
        return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
    }

    @GetMapping("{idSalle}")
    public ResponseEntity<Salle> retrieveSalle(@PathVariable long idSalle) {
        Salle retrievedSalle = iSalleServiceImp.retrieveSalleById(idSalle);
        return new ResponseEntity<>(retrievedSalle, HttpStatus.OK);
    }

    @DeleteMapping("{idSalle}")
    public ResponseEntity<Void> removeSalle(@PathVariable long idSalle) {
        iSalleServiceImp.removeSalle(idSalle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Salle>> retrieveSalles() {
        List<Salle> salles = iSalleServiceImp.retrieveSalles();
        return new ResponseEntity<>(salles, HttpStatus.OK);
    }
}
