package net.azurewebsites.mypet.dto.units;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Krystian Katafoni
 * @since 03.11.2017
 * DTO abstract class for UnitDto classes.
 */
@Getter
@Setter
public abstract class UnitDto {
    private Long id;
    private String description;
}
