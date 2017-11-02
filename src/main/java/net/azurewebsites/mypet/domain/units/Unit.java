package net.azurewebsites.mypet.domain.units;

import javax.persistence.*;

@MappedSuperclass
public abstract class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
}
