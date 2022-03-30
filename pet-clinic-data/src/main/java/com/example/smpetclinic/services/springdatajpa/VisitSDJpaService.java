package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.Visit;
import com.example.smpetclinic.repositories.VisitRepository;
import com.example.smpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("visitsdjpaservice")
public class VisitSDJpaService implements VisitService{

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll(){
        return new HashSet<>(this.visitRepository.findAll());
    }

    @Override
    public Visit findById(Long aLong){
        return this.visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object){
        return this.visitRepository.save(object);
    }

    @Override
    public void delete(Visit object){
        this.visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong){
        this.visitRepository.deleteById(aLong);
    }
}
