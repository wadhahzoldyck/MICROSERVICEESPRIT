package com.example.coach.controllers;

import com.example.coach.clients.SalleRestClient;
import com.example.coach.entities.Coach;
import com.example.coach.model.Salle;
import com.example.coach.repository.CoachRepository;
import com.example.coach.services.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/coach")
public class CoachController {
    private final ICoachService coachService;
    @Autowired
    private  SalleRestClient salleRestClient;

    public CoachController(ICoachService coachService,
                           CoachRepository coachRepository) {
        this.coachService = coachService;
    }

    @PostMapping
    public ResponseEntity<Coach> addCoach(@RequestBody Coach coach) {
        Coach addedCoach = coachService.addCoach(coach);
        return new ResponseEntity<>(addedCoach, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable long id,@RequestBody Coach coach) {
        Coach updatedCoach = coachService.updateCoach(coach);
        return new ResponseEntity<>(updatedCoach, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Coach retrieveCoach(@PathVariable long id) {

        Coach coach= coachService.retrieveCoach(id);
        Salle salle= salleRestClient.findSalleById(coach.getIdSalle());
        coach.setSalle(salle);
        return coach;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Coach>> retrieveAllCoaches() {
        List<Coach> coaches = coachService.retrieveAllCoaches();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable long id) {
        coachService.deleteCoach(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
