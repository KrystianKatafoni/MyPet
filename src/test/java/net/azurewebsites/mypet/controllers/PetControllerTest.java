package net.azurewebsites.mypet.controllers;

import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.events.SavedPetEventProducer;
import net.azurewebsites.mypet.services.CountryService;
import net.azurewebsites.mypet.services.PetService;
import net.azurewebsites.mypet.services.UnitOfLengthService;
import net.azurewebsites.mypet.services.UnitOfWeightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class PetControllerTest {
    
    @Mock
    PetService petService;
    @Mock
    CountryService countryService;
    @Mock
    UnitOfLengthService unitOfLengthService;
    @Mock
    UnitOfWeightService unitOfWeightService;
    @Mock
    SavedPetEventProducer producer;
    
    PetController controller;
    MockMvc mockMvc; 
    @Before
    public void setUp() throws Exception {
        controller = new PetController(petService, countryService, unitOfLengthService, unitOfWeightService, producer);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testNewPet() throws Exception {

        //given

        //when
       mockMvc.perform(get("/pet/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("petDto", "countries", "uolList", "uowList",
                        "def"))
                .andExpect(view().name("pet/petform"));
    }

    @Test
    public void testSaveOrUpdatePet() throws Exception {

        //given
        PetDto petDto = new PetDto();
        petDto.setId(5L);

        when(petService.savePetDto(any())).thenReturn(petDto);

        //when
        mockMvc.perform(post("/pet")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)

        )
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/pet/5/image"));
    }
}
