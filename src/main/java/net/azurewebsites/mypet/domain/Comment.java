package net.azurewebsites.mypet.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Comment class represents comment in database.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"pet"})
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Pet pet;
    @Lob
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Author author;

}
