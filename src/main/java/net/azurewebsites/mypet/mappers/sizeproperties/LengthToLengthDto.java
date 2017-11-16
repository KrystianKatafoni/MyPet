package net.azurewebsites.mypet.mappers.sizeproperties;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.dto.sizeproperties.LengthDto;
import org.modelmapper.ModelMapper;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: Length->LengthDto
 */
@Slf4j
public class LengthToLengthDto {
    ModelMapper modelMapper;
    LengthDto lengthDto;

    public LengthToLengthDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.lengthDto = new LengthDto();
    }

    /**
     *
     * @param length object which represent Length entity taken from database
     * @return Length Data transfer object which represent length passed to front-end layer
     */
    public LengthDto convert(Length length){
        Optional<Length> lengthOpt = Optional.ofNullable(length);
        if (lengthOpt.isPresent()){
            lengthDto = modelMapper.map(lengthOpt.get(), LengthDto.class);
            log.debug("Mapping Length->LengthDto");
        }
        return lengthDto;
    }
}
