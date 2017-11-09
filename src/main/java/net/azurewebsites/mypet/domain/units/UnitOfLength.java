package net.azurewebsites.mypet.domain.units;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
/**
 * @author Krystian Katafoni
 * @since 01.11.2017
 * UnitOfLength class represents some unit of length in database.
 */

@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class UnitOfLength extends Unit {
}
