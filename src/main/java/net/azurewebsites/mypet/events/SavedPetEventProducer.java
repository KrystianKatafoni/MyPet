package net.azurewebsites.mypet.events;

import net.azurewebsites.mypet.dto.PetDto;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 *
 */
@Component
public class SavedPetEventProducer {
    private final ApplicationEventPublisher publisher;

    public SavedPetEventProducer(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    public void publishSavedPetEvent(PetDto petDto){
        publisher.publishEvent(new PetSavedEvent(petDto));
    }
}
