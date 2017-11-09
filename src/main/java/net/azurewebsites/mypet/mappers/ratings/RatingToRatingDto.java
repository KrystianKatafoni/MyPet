package net.azurewebsites.mypet.mappers.ratings;

import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.dto.ratings.RatingDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: Rating->RatingDto
 */
@Component
public class RatingToRatingDto {
    ModelMapper modelMapper;
    RatingDto ratingDto;

    public RatingToRatingDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        ratingDto = new RatingDto();
    }

    /**
     *
     * @param rating object which represent Rating entity taken from database
     * @return Rating Data transfer object which represent rating passed to front-end layer
     */
    public RatingDto convert(Rating rating){
        Optional<Rating> rOpt = Optional.ofNullable(rating);
        if(rOpt.isPresent()){
            ratingDto = modelMapper.map(rOpt.get(), RatingDto.class);
        }
        return ratingDto;
    }
}
