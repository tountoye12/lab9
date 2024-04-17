package com.diallo.lab9.repository;

import com.diallo.lab9.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

     Patient findPatientById(Integer id);

    List<Patient>  findPatientByFirstName(String searchString);
}
