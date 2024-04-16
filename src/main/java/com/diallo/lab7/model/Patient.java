package com.diallo.lab7.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patientNumber;
    private String firstName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address patient_address;
    @OneToMany()
    private List<Appointment> appointments;
}
