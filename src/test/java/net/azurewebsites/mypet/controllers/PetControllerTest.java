package net.azurewebsites.mypet.controllers;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.events.SavedPetEventProducer;
import net.azurewebsites.mypet.mappers.CommentDtoToComment;
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

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    CommentDtoToComment comConv;

    PetController controller;
    MockMvc mockMvc; 
    @Before
    public void setUp() throws Exception {
        controller = new PetController(petService, countryService, unitOfLengthService, unitOfWeightService, comConv);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void testNewPet() throws Exception {

        //given

        //when
       mockMvc.perform(get("/pet/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("petDto", "countries", "uolList", "uowList",
                        "rating"))
                .andExpect(view().name("pet/petform"));
    }

    @Test
    public void testSaveOrUpdatePet() throws Exception {

        //given
        PetDto petDto = new PetDto();
        petDto.setId(5L);
        petDto.setName("Daisy");
        when(petService.savePetDto(any())).thenReturn(petDto);

        //when
        mockMvc.perform(post("/pet")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","")
                .param("name", "some name")

        )
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/pet/5/image"));
    }

    @Test
    public void testShowPetById() throws Exception {
        Long id = 2L;
        PetDto petDto = new PetDto();
        petDto.setId(id);

        when(petService.findPetDtoById(any())).thenReturn(petDto);
        mockMvc.perform(get("/pet/"+id+"/show"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("petDto"))
                .andExpect(view().name("pet/petshow"));
        verify(petService, times(1)).findPetDtoById(anyLong());
    }
    @Test
    public void testShowPetBrowser() throws Exception {
        Long id = 2L;
        PetDto petDto = new PetDto();
        petDto.setId(id);
        List<PetDto> petDtos = new LinkedList<>();
        petDtos.add(petDto);

        when(petService.listAllDtoPets()).thenReturn(petDtos);
        mockMvc.perform(get("/pet/browse"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("petList"))
                .andExpect(view().name("pet/browser"));
       // verify(petService, times(1)).listAllDtoPets();
    }
    @Test
    public void testUpdatePetWithComment() throws Exception {

        //given
        Pet pet = new Pet();
        pet.setId(5L);
        pet.setName("Daisy");
        Comment com = new Comment();
        com.setText("test");
        when(petService.findPetById(any())).thenReturn(pet);
        when(petService.savePet(any())).thenReturn(pet);
        when(comConv.convert(any())).thenReturn(com);

        //when
        mockMvc.perform(post("/pet/"+ pet.getId()+"/comment")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/pet/5/show"));
    }
}
