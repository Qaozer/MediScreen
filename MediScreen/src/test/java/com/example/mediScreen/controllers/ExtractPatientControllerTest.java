package com.example.mediScreen.controllers;

import com.example.mediScreen.models.Patient;
import com.example.mediScreen.services.ExtractPatientService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ExtractPatientControllerTest {

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    private ExtractPatientService extractPatientService;

    @Autowired
    private ExtractPatientController extractPatientController;

    private String createURLWithPort(String uri) {
        return "http://localhost:8080/"+ uri;
    }

    @Test
    public void getPatientByIdTest() throws JSONException {
        Patient patient = new Patient("TestNone","100-222-3333","1 Brookside St","1966-12-31","F", "Test");
        int id = extractPatientService.addPatient(patient).getId();
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("patient/"+id+"/"), HttpMethod.GET, entity, String.class);
        String expected = "{\n" +
                "id: "+id+",\n" +
                "family: \"TestNone\",\n" +
                "phone: \"100-222-3333\",\n" +
                "address: \"1 Brookside St\",\n" +
                "dateOfBirth: \"1966-12-31\",\n" +
                "sex: \"F\",\n" +
                "given: \"Test\"\n" +
                "}";
        System.out.println(response.getBody());
        assertEquals(expected, response.getBody(), true);
    }
}
