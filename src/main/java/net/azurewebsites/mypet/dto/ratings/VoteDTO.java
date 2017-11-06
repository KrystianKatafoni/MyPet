package net.azurewebsites.mypet.dto.ratings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.azurewebsites.mypet.domain.ratings.Scale;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Data Transfer Object class for Vote.
 * VoteDTO serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */
@Getter
@Setter
@NoArgsConstructor
public class VoteDTO {
    private Long id;
    private Scale voteRating;
}
