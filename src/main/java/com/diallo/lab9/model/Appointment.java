package com.diallo.lab9.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    private String title;
//    private String description;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    private Surgery surgery;
    @ManyToOne(cascade = CascadeType.ALL)
    private Dentist dentist;
}
