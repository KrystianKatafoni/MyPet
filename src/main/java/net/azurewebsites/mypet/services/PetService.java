package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;

import java.util.List;
import java.util.Set;

public interface PetService {
    List<Pet> listAllPets();
    List<PetDto> listAllDtoPets();
    PetDto savePetDto(PetDto petDto);
    Pet findPetById(Long id);
    PetDto findPetDtoById(Long id);
    Pet savePet(Pet pet);
}
