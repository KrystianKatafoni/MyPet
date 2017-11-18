package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ImageServiceImplTest {


    @Mock
    PetRepository petRepository;
    ImageService imageService;
    @Before
    public void setUp() throws Exception {
        imageService = new ImageServiceImpl(petRepository);
    }

    @Test
    public void testSaveImageFile() throws Exception {

        //given
        MultipartFile multipartFile = new MockMultipartFile("imagefile", "test.txt", "text/plain", "My Pet App".getBytes());
        Pet pet = new Pet();
        pet.setId(4L);
        Optional<Pet> petOpt = Optional.ofNullable(pet);

        when(petRepository.findById(anyLong())).thenReturn(petOpt);
        ArgumentCaptor<Pet> argumentCaptor = ArgumentCaptor.forClass(Pet.class);

        //when
        imageService.saveImageFile(4L, multipartFile);

        //then
        verify(petRepository, times(1)).findById(anyLong());
        verify(petRepository, times(1)).save(argumentCaptor.capture());
        Pet savedPet = argumentCaptor.getValue();
        assertEquals(multipartFile.getBytes().length, savedPet.getImage().length);


    }
}
