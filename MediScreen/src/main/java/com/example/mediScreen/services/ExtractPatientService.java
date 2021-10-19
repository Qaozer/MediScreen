package com.example.mediScreen.services;

import com.example.mediScreen.models.Patient;
import com.example.mediScreen.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExtractPatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> getById(int id){
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }
}
