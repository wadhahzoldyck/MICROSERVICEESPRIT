package com.example.coach.services;

import com.example.coach.entities.Coach;
import com.example.coach.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ICoachServiceImp implements ICoachService{
    private final CoachRepository coachRepository;

    @Override
    public Coach addCoach(Coach coach) {
        return coachRepository.save(coach);
    }
    @Override
    public Coach updateCoach(Coach coach) {
        return coachRepository.save(coach);
    }
    @Override
    public Coach retrieveCoach(long idCoach) {
        return coachRepository.findById(idCoach).orElse(null);
    }
    @Override
    public void deleteCoach (long idCoach){
        coachRepository.deleteById(idCoach);
    }

}
