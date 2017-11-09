package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
