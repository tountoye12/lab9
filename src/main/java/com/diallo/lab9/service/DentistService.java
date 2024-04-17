package com.diallo.lab9.service;


import com.diallo.lab9.model.Dentist;
import com.diallo.lab9.repository.DentistRepository;
import org.springframework.stereotype.Service;

@Service

public class DentistService {

    private DentistRepository dentistRepository;
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}
