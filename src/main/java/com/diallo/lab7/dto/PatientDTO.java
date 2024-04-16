package com.diallo.lab7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private String patientNumber;
    private String firstName;
    private AddressDTO addressDTO;
//    private String street;
//    private String city;
//    private String state;
//    private String zip;
}
