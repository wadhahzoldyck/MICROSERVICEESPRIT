package com.example.salleservice.clients;

import com.example.salleservice.model.Coach;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="coach-service")
public interface CoachRestClient {

    @GetMapping("/coach/{idCoach}")
    Coach findCoachById(@PathVariable long idCoach);
    @GetMapping("/coach")
    List<Coach> allCoaches();

}
