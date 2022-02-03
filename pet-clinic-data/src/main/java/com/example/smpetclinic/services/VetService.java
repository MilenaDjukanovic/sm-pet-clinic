package com.example.smpetclinic.services;

import com.example.smpetclinic.model.Vet;

import java.util.Set;

public interface VetService{

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
