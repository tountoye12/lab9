package com.diallo.lab7.repository;

import com.diallo.lab7.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AddressRespository  extends JpaRepository<Address, Integer> {
}
