package net.azurewebsites.mypet.dto;

import lombok.Data;
import net.azurewebsites.mypet.domain.KindOfAnimal;
import net.azurewebsites.mypet.domain.Temper;
import net.azurewebsites.mypet.dto.ratings.RatingDTO;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Krystian Katafoni
 * @since 06.11.2017
 * Data Transfer Object class for Pet.
 * PetDTO serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */
@Data
public class PetDTO {
    private Long id;
    private Set<CommentDTO> comments = new HashSet<>();
    private CountryDTO country;
    private Temper temper;
    private KindOfAnimal kindOfAnimal;
    private RatingDTO rating;
    private Byte[] image;
}
