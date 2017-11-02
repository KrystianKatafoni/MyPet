package net.azurewebsites.mypet.domain;

import lombok.Data;
import net.azurewebsites.mypet.domain.ratings.Rating;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Comment> comments = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Country country;

    @Enumerated(value = EnumType.STRING)
    private Temper temper;

    @Enumerated(value = EnumType.STRING)
    private KindOfAnimal kindOfAnimal;

    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;
}
