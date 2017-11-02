package net.azurewebsites.mypet.domain.sizeproperties;

import javax.persistence.*;

@MappedSuperclass
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private double value;

}
