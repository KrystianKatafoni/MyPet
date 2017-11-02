package net.azurewebsites.mypet.domain.ratings;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer votes;
    @Lob
    private Integer ratingSum;
    @Enumerated(value = EnumType.ORDINAL)
    FinalRating finalRating;
}
