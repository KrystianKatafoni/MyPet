package net.azurewebsites.mypet.dto.units;

import lombok.*;

/**
 * @author Krystian Katafoni
 * @since 03.11.2017
 * DTO abstract class for UnitDto classes.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class UnitDto {
    private Long id;
    private String description;
}
