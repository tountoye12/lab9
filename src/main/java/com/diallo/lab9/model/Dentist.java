package com.diallo.lab9.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
//    private String lastName;
//    private String email;
//    private String phone;
//    private String address;
//    private String city;
//    private String state;
//    private String zip;
    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;
}
