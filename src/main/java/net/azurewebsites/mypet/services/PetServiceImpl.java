package net.azurewebsites.mypet.services;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.mappers.PetDtoToPet;
import net.azurewebsites.mypet.mappers.PetToPetDto;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class PetServiceImpl implements PetService{
    PetToPetDto petToPetDto;
    PetDtoToPet petDtoToPet;
    PetRepository petRepository;

    public PetServiceImpl(PetToPetDto petToPetDto, PetDtoToPet petDtoToPet, PetRepository petRepository) {
        this.petToPetDto = petToPetDto;
        this.petDtoToPet = petDtoToPet;
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> listAllPets() {
        return null;
    }

    @Override
    @Transactional
    public PetDto savePetDto(PetDto petDto) {
            PetDto petDtoReturn= new PetDto();
            Pet petMapped = petDtoToPet.convert(petDto);
            Optional<Pet> petMappedOpt = Optional.ofNullable(petMapped);
            if (petMappedOpt.isPresent()){
                Pet savedPet = petRepository.save(petMapped);
                log.debug("Saved pet with id: "+savedPet.getId());
                petDtoReturn = petToPetDto.convert(savedPet);

            }else{
            petMappedOpt.orElseThrow(()-> new IllegalArgumentException("Pet object after mapping is null"));
            log.error("Pet object after mapping is null");
            }
            return petDtoReturn;
    }

    @Override
    public Pet findPetById(Long id) {
       Pet pet =  petRepository.findById(id).get();
       return pet;
    }
}
