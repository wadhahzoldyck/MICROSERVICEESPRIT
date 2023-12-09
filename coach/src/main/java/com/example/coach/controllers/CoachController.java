package com.example.coach.controllers;

import com.example.coach.entities.Coach;
import com.example.coach.services.ICoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CoachController {
    private final ICoachService coachService;

    public CoachController(ICoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping
    public Coach addCoach(@RequestBody Coach coach) {
        Coach addedCoach = coachService.addCoach(coach);
        return addedCoach;
    }

    @PutMapping
    public Coach updateCoach(@RequestBody Coach coach) {
        Coach updatedCoach = coachService.updateCoach(coach);
        return updatedCoach;
    }

    @GetMapping("/{id}")
    public Coach retrieveCoach(@PathVariable long id) {
        Coach coach = coachService.retrieveCoach(id);
        return coach;

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable long id) {
        coachService.deleteCoach(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
