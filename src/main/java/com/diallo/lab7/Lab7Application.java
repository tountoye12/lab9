package com.diallo.lab7;

import com.diallo.lab7.model.*;
import com.diallo.lab7.model.Address;
import com.diallo.lab7.service.AppointmentService;
import com.diallo.lab7.service.DentistService;
import com.diallo.lab7.service.PatientService;
import com.diallo.lab7.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Lab7Application  {



	public static void main(String[] args) {

		SpringApplication.run(Lab7Application.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//
////		System.out.println("Test");
//		Patient gillian = new Patient(null, "P001",
//				"Gillian White", null, null);
//
//		Appointment gillian_Appointment = new Appointment(null,
//				LocalDate.now(), gillian, null, null);
//		Surgery surgery_S15 = new Surgery(null, "S15", null, null);
//
//		Dentist dentist = new Dentist(null, "Tony Smith", null);
//		gillian_Appointment.setPatient(gillian);
//		gillian_Appointment.setSurgery(surgery_S15);
//		gillian_Appointment.setDentist(dentist);
//
//		appointmentService.saveApointment(gillian_Appointment);
//	}
}
