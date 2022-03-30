package com.example.smpetclinic.repositories;

import com.example.smpetclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long>{
}
