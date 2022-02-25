package com.example.smpetclinic.bootstrap;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.model.PetType;
import com.example.smpetclinic.model.Vet;
import com.example.smpetclinic.services.OwnerService;
import com.example.smpetclinic.services.PetTypeService;
import com.example.smpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception{

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = this.petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = this.petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jake");
        owner2.setLastName("Jannison");

        this.ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Tompkins");

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mike");
        vet2.setLastName("Jonson");

        this.vetService.save(vet2);

        System.out.println("Loaded vets....");

    }
}
