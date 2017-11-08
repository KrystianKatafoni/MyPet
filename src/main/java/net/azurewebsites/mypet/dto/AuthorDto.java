package net.azurewebsites.mypet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Krystian Katafoni
 * @since 07.11.2017
 * Data Transfer Object class for Author.
 * AuthorDto serves as a transformation for objects from
 * front-end layer to objects from back-end layer
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String nickname;
}
