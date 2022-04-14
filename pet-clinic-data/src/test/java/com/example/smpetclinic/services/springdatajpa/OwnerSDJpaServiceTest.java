package com.example.smpetclinic.services.springdatajpa;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.repositories.OwnerRepository;
import com.example.smpetclinic.repositories.PetRepository;
import com.example.smpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest{

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;

    private static final String LAST_NAME = "Smith";
    private static final Long ID = 1L;

    private Owner returnOwner = new Owner();

    @BeforeEach
    void setUp(){
        this.returnOwner.setId(ID);
        this.returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findAll(){
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(this.returnOwner);

        when(this.ownerRepository.findAll()).thenReturn(ownerList);

        Set<Owner> foundOwners = this.ownerSDJpaService.findAll();

        assertNotNull(foundOwners);
        assertEquals(foundOwners.size(), ownerList.size());
    }

    @Test
    void findById(){
        when(this.ownerRepository.findById(anyLong())).thenReturn(Optional.of(this.returnOwner));

        Owner owner = this.ownerSDJpaService.findById(1L);

        assertNotNull(owner);
        assertEquals(owner.getId(), this.returnOwner.getId());
    }

    @Test
    void findByIdNotFound(){
        when(this.ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = this.ownerSDJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save(){
        when(this.ownerRepository.save(any())).thenReturn(this.returnOwner);

        Owner savedOwner = this.ownerSDJpaService.save(this.returnOwner);

        verify(this.ownerRepository).save(any());
        assertNotNull(savedOwner);
    }

    @Test
    void delete(){
        this.ownerSDJpaService.delete(this.returnOwner);

        verify(this.ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById(){
        this.ownerSDJpaService.deleteById(1L);

        verify(this.ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName(){
        when(this.ownerRepository.findByLastName(any())).thenReturn(this.returnOwner);

        Owner owner = this.ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(this.ownerRepository).findByLastName(any());
    }
}
