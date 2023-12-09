package com.example.exercice.service;

import com.example.exercice.entity.Exercice;

import java.util.List;

public interface IExerciceService {
    List<Exercice> getAllExercices();

    public Exercice addExercice(Exercice exercice);
    Exercice updateExercice (Exercice e);
    Exercice getExercice(long idExercice);

    void removeExercice(long idExercice);
}
