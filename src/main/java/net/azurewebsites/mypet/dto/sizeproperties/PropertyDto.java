package net.azurewebsites.mypet.dto.sizeproperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Krystian Katafoni
 * @since 03.11.2017
 * DTO abstract class for PropertyDto classes.
 */
@Getter
@Setter
public abstract class PropertyDto {
    private Long id;
    private double value;
}
