package net.azurewebsites.mypet.controllers;

import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.services.ImageService;
import net.azurewebsites.mypet.services.PetService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {
    public static final Long PET_ID= 1L;
    @Mock
    ImageService imageService;
    @Mock
    PetService petService;
    ImageController imageController;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        imageController = new ImageController(imageService, petService);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController)
                .build();

    }

    @Test
    public void testShowUploadForm() throws Exception {
        //given
        PetDto petDto = new PetDto();
        petDto.setId(PET_ID);

        when(petService.findPetDtoById(anyLong())).thenReturn(petDto);

        //when
        mockMvc.perform(get("/pet/1/image"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("petDto"))
                .andExpect(view().name("pet/imageform"));


        verify(petService, times(1)).findPetDtoById(anyLong());

    }

    @Test
    public void testSaveImage() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("imagefile", "test.txt", "text/plain", "My Pet Application".getBytes());

        mockMvc.perform(multipart("/pet/1/image").file(multipartFile))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/index"));
        verify(imageService, times(1)).saveImageFile(anyLong(), any());
    }

}
