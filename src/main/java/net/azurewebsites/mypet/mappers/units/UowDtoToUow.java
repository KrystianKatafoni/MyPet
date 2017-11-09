package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: UnitOfWeightDto->UnitOfWeight
 */
@Component
public class UowDtoToUow {
    private ModelMapper modelMapper;
    private UnitOfWeight uow;

    public UowDtoToUow(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.uow = new UnitOfWeight();
    }

    /**
     *
     * @param uowDto Data transfer object which represent UnitOfWeight taken from front-end
     * @return UnitOfWeight object which represent UnitOfWeight entity in database
     */
    public UnitOfWeight convert(UnitOfWeightDto uowDto) {
        Optional<UnitOfWeightDto> uowDtoOpt = Optional.ofNullable(uowDto);
        if (uowDtoOpt.isPresent()) {
            uow = modelMapper.map(uowDtoOpt.get(), UnitOfWeight.class);
        }
        return uow;
    }
}
