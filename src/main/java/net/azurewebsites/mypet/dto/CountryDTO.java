package net.azurewebsites.mypet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Data Transfer Object class for Country.
 * CountryDTO serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */
@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private Long id;
    private String name;
}
