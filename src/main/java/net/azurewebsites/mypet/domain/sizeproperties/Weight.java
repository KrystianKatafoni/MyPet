package net.azurewebsites.mypet.domain.sizeproperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.azurewebsites.mypet.domain.sizeproperties.Property;

import javax.persistence.Entity;
@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Weight extends Property {

}
