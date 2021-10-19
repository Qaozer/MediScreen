package com.example.mediScreen.controllers;

import com.example.mediScreen.models.Patient;
import com.example.mediScreen.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "patient/{id}/")
    public ResponseEntity getPatientById(@PathVariable("id") Integer id){
        Optional<Patient> patient = patientService.getById(id);
        if (patient.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient.get());
    }

    @PostMapping(value = "patient/add")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }
}
