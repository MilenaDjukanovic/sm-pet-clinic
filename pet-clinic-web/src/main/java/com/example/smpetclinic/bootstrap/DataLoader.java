package com.example.smpetclinic.bootstrap;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.model.Vet;
import com.example.smpetclinic.services.OwnerService;
import com.example.smpetclinic.services.VetService;
import com.example.smpetclinic.services.map.OwnerServiceMap;
import com.example.smpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception{
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Jake");
        owner1.setLastName("Jannison");

        this.ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Tompkins");

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Mike");
        vet1.setLastName("Jonson");

        this.vetService.save(vet2);

        System.out.println("Loaded vets....");

    }
}
