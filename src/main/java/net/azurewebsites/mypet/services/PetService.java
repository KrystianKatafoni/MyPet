package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;

import java.util.Set;

public interface PetService {
    Set<Pet> getPets();
    PetDto savePetDto(PetDto petDto);

}
