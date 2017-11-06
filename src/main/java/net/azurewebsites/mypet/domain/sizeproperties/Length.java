package net.azurewebsites.mypet.domain.sizeproperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
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
}
