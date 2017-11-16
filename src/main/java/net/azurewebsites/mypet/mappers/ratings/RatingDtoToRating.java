package net.azurewebsites.mypet.mappers.ratings;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.dto.ratings.RatingDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: RatingDto->Rating
 */
@Slf4j
@Component
public class RatingDtoToRating {
    ModelMapper modelMapper;
    Rating rating;

    public RatingDtoToRating(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        rating = new Rating();
    }

    /**
     *
     * @param ratingDto Data transfer object which represent rating taken from front-end
     * @return Rating object which represent rating entity in database
     */
    public Rating convert(RatingDto ratingDto){
        Optional<RatingDto> rdOpt = Optional.ofNullable(ratingDto);
        if(rdOpt.isPresent()){
            rating = modelMapper.map(rdOpt.get(), Rating.class);
            log.debug("Mapping RatingDto->Rating");
        }
        return rating;
    }
}
