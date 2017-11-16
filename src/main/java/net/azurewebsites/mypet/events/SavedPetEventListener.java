package net.azurewebsites.mypet.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 *
 */
@Component
public class SavedPetEventListener {

    @EventListener
    void handle(PetSavedEvent event){
        System.out.println("Stworzylem peta");
    }
}
