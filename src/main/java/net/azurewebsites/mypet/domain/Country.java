package net.azurewebsites.mypet.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.azurewebsites.mypet.domain.ratings.Scale;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Country entity represents country in database.
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
