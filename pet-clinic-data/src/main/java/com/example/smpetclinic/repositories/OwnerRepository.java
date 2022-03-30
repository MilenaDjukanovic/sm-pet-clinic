package com.example.smpetclinic.repositories;

import com.example.smpetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long>{

    Owner findByLastName(String lastName);
}
