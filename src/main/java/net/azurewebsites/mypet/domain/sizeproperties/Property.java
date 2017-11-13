package net.azurewebsites.mypet.domain.sizeproperties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Property abstract class represents some property.
 * May extends classes, which represent some property fe. weight, length, velocity.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double value;

}
