package com.example.exercice.controller;

import com.example.exercice.entity.Exercice;
import com.example.exercice.service.IExerciceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8085")
@RequestMapping("/Exercice")
public class ExerciceController {
    @Autowired
    private  IExerciceService iExerciceService;
    @GetMapping
    public List<Exercice> getAllExercices(){
        return iExerciceService.getAllExercices();
    }


    @PostMapping
    public Exercice addExercice(@RequestBody Exercice exercice){
        return iExerciceService.addExercice(exercice);
    }

    @PutMapping
    public Exercice updateExercice(@RequestBody Exercice e){
        return iExerciceService.updateExercice(e);
    }

    @GetMapping("{idExercice}")
    public Exercice getExercice(@PathVariable long idExercice){
        return iExerciceService.getExercice(idExercice);
    }


    @DeleteMapping("{idExercice}")
    public void removeExercice(@PathVariable long idExercice){
        iExerciceService.removeExercice(idExercice);
    }



}
