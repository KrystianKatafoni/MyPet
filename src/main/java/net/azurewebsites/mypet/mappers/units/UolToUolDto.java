package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: UnitOfLength->UnitOfLengthDto
 */
@Component
public class UolToUolDto {
    private ModelMapper modelMapper;
    private UnitOfLengthDto uolDto;

    public UolToUolDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.uolDto = new UnitOfLengthDto();
    }

    /**
     *
     * @param uol UnitOfLength object which represent UnitOfLength entity taken from database
     * @return UnitOfLength Data transfer object which represent UnitOfLength passed to front-end layer
     */
    public UnitOfLengthDto convert(UnitOfLength uol){
        Optional<UnitOfLength> uolOpt = Optional.ofNullable(uol);
        if(uolOpt.isPresent()){
            uolDto = modelMapper.map(uolOpt.get(), UnitOfLengthDto.class);
        }
        return uolDto;
    }
}
