package net.azurewebsites.mypet.dto.sizeproperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;

/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Data Transfer Object class for Weight.
 * WeightDto serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */

@Getter
@Setter
@NoArgsConstructor
public class WeightDto extends PropertyDto {
    private UnitOfWeightDto uow;
}
