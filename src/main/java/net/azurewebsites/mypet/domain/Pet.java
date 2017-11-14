package net.azurewebsites.mypet.domain;

import lombok.Data;
import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.domain.sizeproperties.Weight;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @Enumerated(value = EnumType.STRING)
    private Temper temper;

    @Enumerated(value = EnumType.STRING)
    private KindOfAnimal kindOfAnimal;

    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

    @OneToOne(cascade = CascadeType.ALL)
    private Weight weight;

    @OneToOne(cascade = CascadeType.ALL)
    private Length length;

    @ManyToOne(cascade=CascadeType.ALL)
    private Author author;
    @Lob
    private Byte[] image;
}
