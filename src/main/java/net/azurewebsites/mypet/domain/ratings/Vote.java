package net.azurewebsites.mypet.domain.ratings;

import lombok.*;

import javax.persistence.*;
/**
 * @author Krystian Katafoni
 * @since 06.11.2017
 * Vote class represents vote for pet in database.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Enum value of voting.
     */
    @Enumerated(value = EnumType.ORDINAL)
    private Scale voteRating;
}
