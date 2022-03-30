package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.Speciality;
import com.example.smpetclinic.repositories.SpecialityRepository;
import com.example.smpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService{

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository){
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll(){
        return new HashSet<>(this.specialityRepository.findAll());
    }

    @Override
    public Speciality findById(Long aLong){
        return this.specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object){
        return this.specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object){
        this.specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong){
        this.specialityRepository.deleteById(aLong);
    }
}
