package net.azurewebsites.mypet.domain.units;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * UnitOfWeight class represents some unit of weight in database.
 */

@NoArgsConstructor
@Entity
public class UnitOfWeight extends Unit {
    public UnitOfWeight(String description){
        setDescription(description);
    }
}
