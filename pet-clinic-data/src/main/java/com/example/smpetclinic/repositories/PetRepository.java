package com.example.smpetclinic.repositories;

import com.example.smpetclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long>{
}
