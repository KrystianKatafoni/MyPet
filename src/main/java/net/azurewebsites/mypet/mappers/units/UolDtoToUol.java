package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: UnitOfLengthDto->UnitOfLength
 */
@Component
public class UolDtoToUol {

    private ModelMapper modelMapper;
    private UnitOfLength uol;

    public UolDtoToUol(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.uol = new UnitOfLength();
    }

    /**
     *
     * @param uolDto Data transfer object which represent UnitOfLength taken from front-end
     * @return UnitOfLength object which represent UnitOfLength entity in database
     */
    public UnitOfLength convert(UnitOfLengthDto uolDto){
        Optional<UnitOfLengthDto> uolOpt = Optional.ofNullable(uolDto);
        if(uolOpt.isPresent()){
            uol = modelMapper.map(uolOpt.get(), UnitOfLength.class);
        }
        return uol;
    }
}
