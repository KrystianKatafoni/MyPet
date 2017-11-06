package net.azurewebsites.mypet.domain.sizeproperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.azurewebsites.mypet.domain.units.UnitOfLength;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Length class represents length in database.
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Length extends Property{
    @ManyToOne
    private UnitOfLength uol;
}
