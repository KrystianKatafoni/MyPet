package net.azurewebsites.mypet.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.azurewebsites.mypet.dto.PetDto;


@Getter
@Setter
@AllArgsConstructor
public class PetSavedEvent {
    PetDto petDto;
}
