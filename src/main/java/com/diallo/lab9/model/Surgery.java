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
@Table(name = "surgery")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    private String title;
//    private String description;
    private String surgeryNumber;
    @OneToOne()
    private Address surgery_address;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointmentList;



}
