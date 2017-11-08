package net.azurewebsites.mypet.dto.sizeproperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;

/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Data Transfer Object class for Length.
 * LengthDto serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */

@Getter
@Setter
@NoArgsConstructor
public class LengthDto extends PropertyDto {
    private UnitOfLengthDto uol;
}
