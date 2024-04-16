package com.diallo.lab7.controller;


import com.diallo.lab7.dto.PatientDTO;
import com.diallo.lab7.exception.PatientNotFoundException;
import com.diallo.lab7.model.Patient;
import com.diallo.lab7.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adsweb/api/v1/patient")
@Slf4j
public class PatientController {

    private  PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    /*
    1. HTTP GET request: http://localhost:8080/adsweb/api/v1/patient/list -
        Displays the list of all Patients,
        including their primaryAddresses, sorted in ascending
        order by their lastName, in JSON format.
     */
    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getAllPatients() {
       return ResponseEntity.ok(patientService.getAllPatient());
    }

    /*
    3. HTTP POST request: http://localhost:8080/adsweb/api/v1/patient/register - Register a new Patient
    into the system.
    Note: You supply the correct/appropriate Patient data in JSON format
     */

    @PostMapping("/register")
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDto) {
        patientService.savePatient(patientDto);
        return ResponseEntity.ok(patientDto);
    }

    /*
    HTTP GET request: http://localhost:8080/adsweb/api/v1/patient/get/1 - Displays the data for Patient
    whose PatientId is 1 including the primaryAddress, in JSON format. Also, make sure to
    implement appropriate exception handling, for where patientId is invalid and not found.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id")  Integer id) throws PatientNotFoundException {

        return ResponseEntity.ok(patientService.findPatientById(id));
    }

    /*
    4. HTTP PUT request: http://localhost:8080/adsweb/api/v1/patient/update/1
    - Retrieves and updates Patient
     data for the patient whose patientId is 1 (or any other
     valid patientId). Also, make sure to
    implement appropriate exception handling,
    for where patientId is invalid and not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable("id") Integer id,
                                                 @RequestBody PatientDTO patientDTO ) throws PatientNotFoundException {
        patientService.updatePatient(id, patientDTO);
        return ResponseEntity.ok(patientDTO);
    }

    /*
    5. HTTP DELETE request: http://localhost:8080/adsweb/api/v1/patient/delete/1 -
    Deletes the Patient data for the patient
    whose patientId is 1 (or any other valid patientId).
     */

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable("id") Integer id) throws PatientNotFoundException {
        patientService.deletePatient(id);
    }

    /*
    6. http://localhost:8080/adsweb/api/v1/patient/search/{searchString}
    - Queries all the Patient data for the patient(s) whose
        data matches the input searchString.
     */

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatient(@PathVariable("searchString") String searchString) throws PatientNotFoundException {
        List<Patient> patientList = patientService.findByFirstName(searchString);
        if (patientList.isEmpty())
            throw new PatientNotFoundException("Patient with : " + searchString + " not found ");
        return ResponseEntity.ok(patientList);
    }


}

