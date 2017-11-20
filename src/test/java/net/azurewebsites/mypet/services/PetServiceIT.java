package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.KindOfAnimal;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.mappers.PetToPetDto;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PetServiceIT {
    public static final String PET_NAME = "Name";
    public static final String PET_NAME_NEW = "New_name";
    public static final KindOfAnimal KIND = KindOfAnimal.DOG;
    public static final KindOfAnimal KIND_NEW = KindOfAnimal.CHINCHILA;

    @Autowired
    PetService petService;

    @Autowired
    PetRepository petRepository;

    @Autowired
    PetToPetDto petToPetDto;



    @Test
    public void testSavePetDto() throws Exception {

        //given
        Pet pet = new Pet();
        pet.setName(PET_NAME);
        pet.setKindOfAnimal(KIND);
        Pet savedPet = petRepository.save(pet);
        PetDto petDto = petToPetDto.convert(savedPet);
        //when
        petDto.setName(PET_NAME_NEW);
        petDto.setKindOfAnimal(KIND_NEW);
        PetDto savedPetDto = petService.savePetDto(petDto);

        //then
        assertEquals(PET_NAME_NEW, savedPetDto.getName());
        assertEquals(KIND_NEW, savedPetDto.getKindOfAnimal());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSavePetDtoIllegalArgument() throws Exception {

        PetDto savedPetDto = petService.savePetDto(null);
    }
}
