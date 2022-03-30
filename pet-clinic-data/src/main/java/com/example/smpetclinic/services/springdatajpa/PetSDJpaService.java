package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.Pet;
import com.example.smpetclinic.repositories.PetRepository;
import com.example.smpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService{

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll(){
        return new HashSet<>(this.petRepository.findAll());
    }

    @Override
    public Pet findById(Long aLong){
        return this.petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object){
        return this.petRepository.save(object);
    }

    @Override
    public void delete(Pet object){
        this.petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong){
        this.petRepository.deleteById(aLong);
    }
}
