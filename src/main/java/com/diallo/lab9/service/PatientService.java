package com.diallo.lab9.service;


import com.diallo.lab9.dto.PatientDTO;
import com.diallo.lab9.exception.PatientNotFoundException;
import com.diallo.lab9.model.Address;
import com.diallo.lab9.model.Patient;
import com.diallo.lab9.repository.AddressRespository;
import com.diallo.lab9.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    private AddressRespository addressRespository;
    public  PatientService(PatientRepository patientRepository, AddressRespository addressRespository){

        this.patientRepository = patientRepository;
        this.addressRespository = addressRespository;
    }

    public Patient savePatient(PatientDTO patientDTO){
        Address address = new Address();
        if (patientDTO.getAddressDTO() != null) {
            BeanUtils.copyProperties(patientDTO.getAddressDTO(), address);
            addressRespository.save(address);
        }
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDTO,patient);
        patient.setPatient_address(address);
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public PatientDTO findPatientById(Integer id) throws PatientNotFoundException {

        Optional<Patient> patient = patientRepository.findById(id);
        if(!patient.isPresent())
            throw new PatientNotFoundException("Patient not found");
        else {
            PatientDTO patientDTO = new PatientDTO();
            BeanUtils.copyProperties(patient.get(),patientDTO);
            return patientDTO;
        }
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findByFirstName(String searchString) throws PatientNotFoundException {
        System.out.println("searchString: " + searchString);
        return patientRepository.findPatientByFirstName(searchString);
    }

    public PatientDTO updatePatient(Integer id, PatientDTO patientDTO) throws PatientNotFoundException {
       Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));

       if (patientDTO.getAddressDTO() != null && patient.getPatient_address() != null) {
           Address address = patient.getPatient_address();
           address.setStreet(patientDTO.getAddressDTO().getStreet());
           address.setCity(patientDTO.getAddressDTO().getCity());
           address.setState(patientDTO.getAddressDTO().getState());
           address.setZip(patientDTO.getAddressDTO().getZip());
           addressRespository.save(address);
       }
        patient.setPatientNumber(patientDTO.getPatientNumber());
        patient.setFirstName(patientDTO.getFirstName());
        Patient patient1 = patientRepository.save(patient);
        BeanUtils.copyProperties(patientDTO,patient1);
        return patientDTO;
    }
}
