package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: Rating->RatingDto
 */
@Component
public class PetToPetDto {
    ModelMapper modelMapper;
    PetDto petDto;

    public PetToPetDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.petDto = new PetDto();
    }
    /**
     *
     * @param pet object which represent Pet entity taken from database
     * @return Pet Data transfer object which represent pet passed to front-end layer
     */
    public PetDto convert(Pet pet){
        Optional<Pet> petOpt = Optional.ofNullable(pet);
        if (petOpt.isPresent()){
            petDto = modelMapper.map(petOpt.get(),PetDto.class);
        }
        return petDto;
    }
}
