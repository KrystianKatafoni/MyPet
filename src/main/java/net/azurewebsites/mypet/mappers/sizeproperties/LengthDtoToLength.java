package net.azurewebsites.mypet.mappers.sizeproperties;

import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.dto.sizeproperties.LengthDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: LengthDto->Length
 */
@Component
public class LengthDtoToLength {
    ModelMapper modelMapper;
    Length length;

    public LengthDtoToLength(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.length = new Length();
    }

    /**
     *
     * @param lengthDto Data transfer object which represent Length taken from front-end
     * @return Length object which represent length entity in database
     */
    public Length convert(LengthDto lengthDto){
        Optional<LengthDto> ldOpt = Optional.ofNullable(lengthDto);
        if (ldOpt.isPresent()){
            length = modelMapper.map(ldOpt.get(), Length.class);
        }
        return length;
    }
}
