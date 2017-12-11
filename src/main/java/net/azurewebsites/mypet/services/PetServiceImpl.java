package net.azurewebsites.mypet.services;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.exceptions.NotFoundException;
import net.azurewebsites.mypet.mappers.PetDtoToPet;
import net.azurewebsites.mypet.mappers.PetToPetDto;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * This service deserve to handle Pet object
 */
@Slf4j
@Service
public class PetServiceImpl implements PetService {
    PetToPetDto petToPetDto;
    PetDtoToPet petDtoToPet;
    PetRepository petRepository;

    public PetServiceImpl(PetToPetDto petToPetDto, PetDtoToPet petDtoToPet, PetRepository petRepository) {
        this.petToPetDto = petToPetDto;
        this.petDtoToPet = petDtoToPet;
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> listAllPets() {

        List<Pet> petList = new LinkedList<>();
        petRepository.findAll().iterator().forEachRemaining(petList::add);

        return petList;
    }

    @Override
    @Transactional
    public PetDto savePetDto(PetDto petDto) {
        PetDto petDtoReturn = new PetDto();
        Optional<PetDto> petDtoOpt = Optional.ofNullable(petDto);
        petDtoOpt.orElseThrow(() -> new IllegalArgumentException("petDto has null value"));
        //convert
        Pet petMapped = petDtoToPet.convert(petDtoOpt.get());
        //save Pet
        Pet savedPet = petRepository.save(petMapped);
        log.debug("Saved pet with id: " + savedPet.getId());
        petDtoReturn = petToPetDto.convert(savedPet);
        return petDtoReturn;
    }

    @Override
    public Pet findPetById(Long id) {
        Optional<Pet> petOpt = petRepository.findById(id);
        petOpt.orElseThrow(NotFoundException::new);
        return petOpt.get();
    }

    @Override
    public PetDto findPetDtoById(Long id) {
        Optional<Pet> petOpt = petRepository.findById(id);
        petOpt.orElseThrow(NotFoundException::new);
        PetDto petDto = petToPetDto.convert(petOpt.get());
        return petDto;
    }

    @Override
    public Pet savePet(Pet pet) {
        Pet savedPet = petRepository.save(pet);
        log.debug("Saved pet with id: " + savedPet.getId());
        return savedPet;
    }

    @Override
    public List<PetDto> listAllDtoPets() {
        List<Pet> petList = new LinkedList<>();
        petRepository.findAll().iterator().forEachRemaining(petList::add);
        List<PetDto> petDtoList = petList.stream().map(petToPetDto::convert).collect(Collectors.toList());
        return petDtoList;
    }
}
