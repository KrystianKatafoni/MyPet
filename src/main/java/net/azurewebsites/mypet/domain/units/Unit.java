package net.azurewebsites.mypet.domain.units;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Unit abstract class represents some unit.
 * May extends classes, which represent some unit fe. unit of weight, unit of height.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;


}
