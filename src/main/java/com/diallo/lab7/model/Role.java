package com.diallo.lab7.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    protected Long id;
    protected String roleName;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToOne
    private Dentist dentist;
    @OneToOne
    private Patient patient;
}
