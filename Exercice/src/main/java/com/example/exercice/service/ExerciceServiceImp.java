package com.example.exercice.service;

import com.example.exercice.entity.Exercice;
import com.example.exercice.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExerciceServiceImp implements IExerciceService{
    @Autowired
    ExerciceRepository exerciceRepository;

    @Override
    public List<Exercice> getAllExercices() {
        return (List<Exercice> )exerciceRepository.findAll();
    }



    @Override
    public Exercice addExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    @Override
    public Exercice updateExercice(Exercice e) {
        return exerciceRepository.save(e);
    }

    @Override
    public Exercice getExercice(long idExercice) {
        return exerciceRepository.findById(idExercice).orElseThrow(() -> new IllegalArgumentException("No Exercice Found with this id"));

    }

    @Override
    public void removeExercice(long idExercice) {
        exerciceRepository.deleteById(idExercice);


    }
}
