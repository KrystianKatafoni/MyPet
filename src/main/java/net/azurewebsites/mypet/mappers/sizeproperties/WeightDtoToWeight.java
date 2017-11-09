package net.azurewebsites.mypet.mappers.sizeproperties;

import net.azurewebsites.mypet.domain.sizeproperties.Weight;
import net.azurewebsites.mypet.dto.sizeproperties.WeightDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 09.11.2017
 * Mapper class which handle mapping objects: WeightDto->Weight
 */
@Component
public class WeightDtoToWeight {
    ModelMapper modelMapper;
    Weight weight;

    public WeightDtoToWeight(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.weight = new Weight();
    }

    /**
     *
     * @param weightDto Data transfer object which represent Weight taken from front-end
     * @return Weight object which represent Weight entity in database
     */
    public Weight convert(WeightDto weightDto){
        Optional<WeightDto> wdOpt = Optional.ofNullable(weightDto);
        if (wdOpt.isPresent()){
            weight = modelMapper.map(wdOpt.get(), Weight.class);
        }
        return weight;
    }
}
