package com.example.smpetclinic.repositories;

import com.example.smpetclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long>{
}
