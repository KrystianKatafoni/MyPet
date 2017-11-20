package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.exceptions.NotFoundException;
import net.azurewebsites.mypet.mappers.PetDtoToPet;
import net.azurewebsites.mypet.mappers.PetToPetDto;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

    public static final Long PET_ID = 3L;
    public static final String PET_NAME = "Daisy";
    PetService petService;
    @Mock
    PetToPetDto petToPetDto;
    @Mock
    PetDtoToPet petDtoToPet;
    @Mock
    PetRepository petRepository;

    @Before
    public void setUp() throws Exception {
        petService = new PetServiceImpl(petToPetDto, petDtoToPet, petRepository);
    }

    @Test
    public void testFindPetById() throws Exception {

        //given
        Pet pet = new Pet();
        pet.setId(PET_ID);
        pet.setName(PET_NAME);
        Optional<Pet> petOpt = Optional.ofNullable(pet);
        when(petRepository.findById(anyLong())).thenReturn(petOpt);
        //when
        Pet foundedPet = petService.findPetById(PET_ID);

        //then
        assertNotNull(foundedPet);
        assertEquals(PET_ID, foundedPet.getId());
        assertEquals(PET_NAME, foundedPet.getName());
        verify(petRepository, times(1)).findById(anyLong());

    }

    @Test(expected = NotFoundException.class)
    public void testFindPetByIdNotFound() throws Exception {

        //given
        Optional<Pet> petOpt = Optional.empty();
        when(petRepository.findById(anyLong())).thenReturn(petOpt);
        Pet foundedPet = petService.findPetById(PET_ID);
        //there should be not found exception
    }

    @Test
    public void testFindPetDtoById() throws Exception {
        Pet pet = new Pet();
        pet.setId(PET_ID);
        pet.setName(PET_NAME);
        PetDto petDto =new PetDto();
        petDto.setId(PET_ID);
        petDto.setName(PET_NAME);
        Optional<Pet> petOpt = Optional.ofNullable(pet);

        when(petRepository.findById(anyLong())).thenReturn(petOpt);
        when(petToPetDto.convert(any(Pet.class))).thenReturn(petDto);
        //when
        PetDto foundedPet = petService.findPetDtoById(PET_ID);

        //then

        verify(petRepository, times(1)).findById(anyLong());
        assertNotNull(foundedPet);
        assertEquals(PET_ID, foundedPet.getId());
        assertEquals(PET_NAME, foundedPet.getName());


    }
    @Test(expected = NotFoundException.class)
    public void testFindPetDtoByIdNotFound() throws Exception {

        //given
        Optional<Pet> petOpt = Optional.empty();
        when(petRepository.findById(anyLong())).thenReturn(petOpt);
        //when
        PetDto foundedPet = petService.findPetDtoById(PET_ID);
        //there should be not found exception
    }
}
