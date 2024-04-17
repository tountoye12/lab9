package com.diallo.lab9.service;


import com.diallo.lab9.model.Surgery;
import com.diallo.lab9.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

@Service

public class SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
    public Surgery save(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
