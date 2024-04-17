package com.diallo.lab9.service;

import com.diallo.lab9.model.Appointment;
import com.diallo.lab9.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service

public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveApointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
