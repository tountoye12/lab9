package com.diallo.lab7.repository;

import com.diallo.lab7.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
