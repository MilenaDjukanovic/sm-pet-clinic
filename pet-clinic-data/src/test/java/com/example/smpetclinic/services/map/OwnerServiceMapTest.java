package com.example.smpetclinic.services.map;

import com.example.smpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest{

    private OwnerServiceMap ownerServiceMap;

    private final Long ownerId = 1L;

    private final String lastName = "Smith";

    @BeforeEach
    void setUp(){
        this.ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(this.ownerId);
        owner.setLastName(this.lastName);
        this.ownerServiceMap.save(owner);
    }

    @Test
    void findAll(){
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById(){
        this.ownerServiceMap.deleteById(this.ownerId);

        assertEquals(0, this.ownerServiceMap.findAll().size());
    }

    @Test
    void delete(){
        this.ownerServiceMap.delete(this.ownerServiceMap.findById(this.ownerId));

        assertEquals(0, this.ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingID(){
        final Long id = 2L;
        Owner owner = new Owner();
        owner.setId(id);

        Owner savedOwner = this.ownerServiceMap.save(owner);

        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void saveNewID(){
        Owner savedOwner = this.ownerServiceMap.save(new Owner());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById(){
        Owner owner = this.ownerServiceMap.findById(this.ownerId);

        assertEquals(owner.getId(), this.ownerId);
    }

    @Test
    void findByLastName(){
        Owner owner = this.ownerServiceMap.findByLastName(this.lastName);

        assertNotNull(owner);
        assertEquals(owner.getId(), this.ownerId);
        assertEquals(owner.getLastName(), this.lastName);
    }

    @Test
    void findByLastNameNotFound(){
        Owner owner = this.ownerServiceMap.findByLastName("");

        assertNull(owner);
    }
}
