package net.azurewebsites.mypet.mappers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.PetDto;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 10.11.2017
 * Mapper class which handle mapping objects: PetDto->Pet
 */
@Slf4j
@Component
public class PetDtoToPet {
    ModelMapper modelMapper;
    Pet pet;

    public PetDtoToPet(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        pet = new Pet();
    }
    /**
     *
     * @param petDto Data transfer object which represent pet taken from front-end
     * @return Pet object which represent pet entity in database
     */
    public Pet convert(PetDto petDto){
        Optional<PetDto> petDtoOpt = Optional.ofNullable(petDto);
        if (petDtoOpt.isPresent()){
                pet = modelMapper.map(petDtoOpt.get(), Pet.class);
                log.debug("Mapping PetDto->Pet");
        }
        return pet;
    }
}
