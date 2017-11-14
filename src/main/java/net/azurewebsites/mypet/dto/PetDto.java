package net.azurewebsites.mypet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.azurewebsites.mypet.domain.KindOfAnimal;
import net.azurewebsites.mypet.domain.Temper;
import net.azurewebsites.mypet.dto.ratings.RatingDto;
import net.azurewebsites.mypet.dto.sizeproperties.LengthDto;
import net.azurewebsites.mypet.dto.sizeproperties.WeightDto;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Krystian Katafoni
 * @since 06.11.2017
 * Data Transfer Object class for Pet.
 * PetDto serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */
@Getter
@Setter
@NoArgsConstructor
public class PetDto {
    private Long id;

    private CountryDto country;
    private Temper temper;
    private KindOfAnimal kindOfAnimal;
    private RatingDto rating;

    private WeightDto weight;

    private LengthDto length;

    private AuthorDto author;
    private Set<CommentDto> comments = new HashSet<>();

    private String name;

    private Byte[] image;
}
