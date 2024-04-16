package com.diallo.lab7.repository;

import com.diallo.lab7.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository  extends JpaRepository<Dentist, Long> {


}
