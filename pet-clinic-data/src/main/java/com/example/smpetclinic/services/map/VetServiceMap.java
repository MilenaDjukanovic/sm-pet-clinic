package com.example.smpetclinic.services.map;

import com.example.smpetclinic.model.Speciality;
import com.example.smpetclinic.model.Vet;
import com.example.smpetclinic.services.SpecialtyService;
import com.example.smpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

    private final SpecialtyService specialityService;

    public VetServiceMap(SpecialtyService specialityService){
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll(){
        return super.findAll();
    }

    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object){
        super.delete(object);
    }

    @Override
    public Vet save(Vet object){
        if(object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Speciality createdSpecialty = this.specialityService.save(specialty);
                    specialty.setId(createdSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id){
        return super.findById(id);
    }
}
