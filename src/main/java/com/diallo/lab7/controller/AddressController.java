package com.diallo.lab7.controller;


import com.diallo.lab7.dto.AddressDTO;
import com.diallo.lab7.model.Address;
import com.diallo.lab7.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address/")

public class AddressController {

    private  AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        addressService.save(address);
        return ResponseEntity.ok(addressDTO);
    }

    /*
    7. HTTP GET request: http://localhost:8080/adsweb/api/v1/address/list - Displays the list
    of all Addresses,
    including the Patient data, sorted in ascending order by their city, in JSON format.
     */

    @GetMapping("/list")
    public  ResponseEntity<List<Address>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAll());
    }

}
