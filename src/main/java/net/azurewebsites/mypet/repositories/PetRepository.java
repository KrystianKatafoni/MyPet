package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 */
public interface PetRepository extends CrudRepository<Pet,Long> {
}
