package net.azurewebsites.mypet.domain.ratings;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Rating class represents rating for pet in database.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Amount of votes
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
    private Set<Vote> votes = new HashSet<>();
    /**
     * Final Rating of rating object.
     * This field should be set by method setFinalRating()
     * in case of creating or updating Rating.
     */
    @Enumerated(value = EnumType.ORDINAL)
    private Scale finalRating;
}
