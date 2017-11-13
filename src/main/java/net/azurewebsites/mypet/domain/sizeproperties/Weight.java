package net.azurewebsites.mypet.domain.sizeproperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.azurewebsites.mypet.domain.sizeproperties.Property;
import net.azurewebsites.mypet.domain.units.UnitOfWeight;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * Weight class represents weight in database.
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Weight extends Property {

    @ManyToOne
    private UnitOfWeight uow;
}
