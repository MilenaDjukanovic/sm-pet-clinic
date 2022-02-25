package com.example.smpetclinic.bootstrap;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.model.Pet;
import com.example.smpetclinic.model.PetType;
import com.example.smpetclinic.model.Vet;
import com.example.smpetclinic.services.OwnerService;
import com.example.smpetclinic.services.PetTypeService;
import com.example.smpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("V proleterske broj 15 ");
        owner1.setCity("Podgorica");
        owner1.setTelephone("0611782677");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jake");
        owner2.setLastName("Jannison");
        owner2.setAddress("Svetog Nikole 14");
        owner2.setCity("Belgrade");
        owner2.setTelephone("155454554");

        Pet jakePet = new Pet();
        jakePet.setPetType(savedCatType);
        jakePet.setOwner(owner2);
        jakePet.setBirthDate(LocalDate.now());
        jakePet.setName("Ferdinand");
        owner2.getPets().add(jakePet);
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
