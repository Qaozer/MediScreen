package com.example.mediScreen.services;

import com.example.mediScreen.models.Patient;
import com.example.mediScreen.repositories.PatientRepository;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.skyscreamer.jsonassert.JSONAssert.*;

@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
@Transactional
public class ExtractPatientServiceTest {

    @Autowired
    private ExtractPatientService extractPatientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void getPatientByIdTest() throws JSONException {
        Patient inserted = new Patient("TestNone","100-222-3333","1 Brookside St","1966-12-31","F", "Test");
        int id = patientRepository.save(inserted).getId();

        Patient extracted = extractPatientService.getById(id).get();
        assertEquals(inserted.getDateOfBirth(), extracted.getDateOfBirth(), true);
        assertEquals(inserted.getAddress(), extracted.getAddress(), true);
        assertEquals(inserted.getPhone(), extracted.getPhone(), true);
        assertEquals(inserted.getSex(), extracted.getSex(), true);
        assertEquals(inserted.getGiven(), extracted.getGiven(), true);
        assertEquals(inserted.getFamily(), extracted.getFamily(), true);
    }
}
