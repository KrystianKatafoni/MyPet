package net.azurewebsites.mypet.mappers.sizeproperties;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.sizeproperties.Weight;
import net.azurewebsites.mypet.dto.sizeproperties.WeightDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Slf4j
@Component
public class WeightToWeightDto {
    ModelMapper modelMapper;
    WeightDto weightDto;

    public WeightToWeightDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.weightDto = new WeightDto();
    }

    /**
     *
     * @param weight object which represent Weight entity taken from database
     * @return Weight Data transfer object which represent weight passed to front-end layer
     */
    public WeightDto convert(Weight weight){
        Optional<Weight> weightOpt = Optional.ofNullable(weight);
        if (weightOpt.isPresent()){
            weightDto = modelMapper.map(weightOpt.get(), WeightDto.class);
            log.debug("Mapping Weight->WeightDto");
        }
        return weightDto;
    }
}
