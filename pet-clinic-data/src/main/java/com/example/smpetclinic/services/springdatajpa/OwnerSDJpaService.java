package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.repositories.OwnerRepository;
import com.example.smpetclinic.repositories.PetRepository;
import com.example.smpetclinic.repositories.PetTypeRepository;
import com.example.smpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService{

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository){
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll(){
        return new HashSet<>(this.ownerRepository.findAll());
    }

    @Override
    public Owner findById(Long aLong){
        return this.ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object){
        return this.ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object){
        this.ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong){
        this.ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName){
        return this.ownerRepository.findByLastName(lastName);
    }
}
