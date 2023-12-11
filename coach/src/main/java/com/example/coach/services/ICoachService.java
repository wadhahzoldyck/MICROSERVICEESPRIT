package com.example.coach.services;

import com.example.coach.entities.Coach;

import java.util.List;

public interface ICoachService {
    public Coach addCoach(Coach coach);
    public Coach updateCoach(Coach coach);
    public Coach retrieveCoach(long idCoach);
    public void deleteCoach (long idCoach);
    public List<Coach> retrieveAllCoaches();
}
