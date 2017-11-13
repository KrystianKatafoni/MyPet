package net.azurewebsites.mypet.domain;

import lombok.Data;
import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.domain.sizeproperties.Weight;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Pet class represents one Pet in database.
 */
@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    private Country country;

    @Enumerated(value = EnumType.STRING)
    private Temper temper;

    @Enumerated(value = EnumType.STRING)
    private KindOfAnimal kindOfAnimal;

    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

    @OneToOne
    private Weight weight;

    @OneToOne
    private Length length;

    @ManyToOne
    private Author author;

    @Lob
    private Byte[] image;
}
