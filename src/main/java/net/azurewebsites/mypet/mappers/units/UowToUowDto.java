package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: UnitOfWeight->UnitOfWeightDto
 */
@Component
public class UowToUowDto {
    private ModelMapper modelMapper;
    private UnitOfWeightDto uowDto;

    public UowToUowDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.uowDto = new UnitOfWeightDto();
    }

    /**
     *
     * @param uow UnitOfWeight object which represent UnitOfWeight entity taken from database
     * @return UnitOfWeight Data transfer object which represent UnitOfWeight passed to front-end layer
     */
    public UnitOfWeightDto convert(UnitOfWeight uow) {
        Optional<UnitOfWeight> uowOpt = Optional.ofNullable(uow);
        if (uowOpt.isPresent()) {
            uowDto = modelMapper.map(uowOpt.get(), UnitOfWeightDto.class);
        }
        return uowDto;
    }
}
