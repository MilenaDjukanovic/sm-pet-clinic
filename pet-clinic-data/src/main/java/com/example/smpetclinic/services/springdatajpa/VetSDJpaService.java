package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.Vet;
import com.example.smpetclinic.repositories.VetRepository;
import com.example.smpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository){
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll(){
        return new HashSet<>(this.vetRepository.findAll());
    }

    @Override
    public Vet findById(Long aLong){
        return this.vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object){
        return this.vetRepository.save(object);
    }

    @Override
    public void delete(Vet object){
        this.vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong){
        this.vetRepository.deleteById(aLong);
    }
}
