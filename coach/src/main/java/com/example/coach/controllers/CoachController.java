package com.example.coach.controllers;

import com.example.coach.entities.Coach;
import com.example.coach.services.ICoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {
    private final ICoachService coachService;

    public CoachController(ICoachService coachService) {
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
    public ResponseEntity<Coach> retrieveCoach(@PathVariable long id) {
        Coach coach = coachService.retrieveCoach(id);
        if (coach != null) {
            return new ResponseEntity<>(coach, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
