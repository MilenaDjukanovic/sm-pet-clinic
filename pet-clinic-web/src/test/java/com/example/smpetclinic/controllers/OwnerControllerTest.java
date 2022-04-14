package com.example.smpetclinic.controllers;

import com.example.smpetclinic.model.Owner;
import com.example.smpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest{

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    Set<Owner> ownerSet;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        this.ownerSet = new HashSet<>();

        Owner owner = new Owner();
        owner.setId(1L);

        Owner secondOwner = new Owner();
        secondOwner.setId(2L);

        this.ownerSet.add(owner);
        this.ownerSet.add(secondOwner);

        this.mockMvc = MockMvcBuilders
                .standaloneSetup(this.ownerController)
                .build();
    }

    @Test
    void listOwners() throws Exception{
        when(this.ownerService.findAll()).thenReturn(this.ownerSet);

        this.mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception{
        when(this.ownerService.findAll()).thenReturn(this.ownerSet);

        this.mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception{
        this.mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));

        verifyNoInteractions(this.ownerService);
    }
}
