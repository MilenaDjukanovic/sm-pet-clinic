package com.example.smpetclinic.services.map;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.model.Pet;
import com.example.smpetclinic.services.OwnerService;
import com.example.smpetclinic.services.PetService;
import com.example.smpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService){
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll(){
        return super.findAll();
    }

    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object){
        super.delete(object);
    }

    @Override
    public Owner save(Owner object){
        if(object != null) {
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(this.petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId() == null) {
                        Pet savedPet = this.petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id){
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName){
        return null;
    }
}
