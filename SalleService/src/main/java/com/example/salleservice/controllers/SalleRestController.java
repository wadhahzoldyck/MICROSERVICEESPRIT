package com.example.salleservice.controllers;

import com.example.salleservice.Entities.Salle;
import com.example.salleservice.clients.CoachRestClient;
import com.example.salleservice.model.Coach;
import com.example.salleservice.services.ISalleServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/salle")
@CrossOrigin(origins = "*")
@Slf4j
@AllArgsConstructor
public class SalleRestController {
    private final ISalleServiceImp iSalleServiceImp;

    private final CoachRestClient coachRestClient ;

    @PostMapping(value = "/addSalle", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Salle> addSalle(
            @RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("Location")  String location,
            @RequestParam("capacity") int capacity
    ) throws IOException, SQLException {
        Salle salle = new Salle();
        salle.setName(name);
        salle.setCapacity(capacity);
        salle.setLocation(location);
        if (!image.isEmpty()) {
            byte[] fileBytes = image.getBytes();
            Blob blob = new SerialBlob(fileBytes);
            salle.setImage(blob);
            Salle addedSalle = iSalleServiceImp.addSalle(salle);
            return new ResponseEntity<>(addedSalle, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateSalle")
    public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) {
        Salle updatedSalle = iSalleServiceImp.updateSalle(salle);
        return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
    }

    @GetMapping("/{idSalle}")
    public ResponseEntity<Salle> retrieveSalle(@PathVariable long idSalle) {
        List<Coach> coaches = new ArrayList<>();
        Salle retrievedSalle = iSalleServiceImp.retrieveSalleById(idSalle);
        for(Long i : retrievedSalle.getIdCoach()){
          coaches.add(coachRestClient.findCoachById(i));

        }
        retrievedSalle.setCoaches(coaches);
        return new ResponseEntity<>(retrievedSalle, HttpStatus.OK);
    }

    @DeleteMapping("/{idSalle}")
    public ResponseEntity<Void> removeSalle(@PathVariable long idSalle) {
        iSalleServiceImp.removeSalle(idSalle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Salle>> retrieveSalles() {
        List<Salle> salles = iSalleServiceImp.retrieveSalles();
        return new ResponseEntity<>(salles, HttpStatus.OK);
    }
}
