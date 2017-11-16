package net.azurewebsites.mypet.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.azurewebsites.mypet.dto.PetDto;

/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class PetSavedEvent {
    PetDto petDto;
}
