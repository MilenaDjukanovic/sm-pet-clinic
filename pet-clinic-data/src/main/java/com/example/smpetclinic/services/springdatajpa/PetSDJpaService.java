package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.PetType;
import com.example.smpetclinic.repositories.PetTypeRepository;
import com.example.smpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("petsdjpaservice")
public class PetSDJpaService implements PetTypeService{

    private final PetTypeRepository petTypeRepository;

    public PetSDJpaService(PetTypeRepository petTypeRepository){
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll(){
        return new HashSet<>(this.petTypeRepository.findAll());
    }

    @Override
    public PetType findById(Long aLong){
        return this.petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object){
        return this.petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object){
        this.petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong){
        this.deleteById(aLong);
    }
}
