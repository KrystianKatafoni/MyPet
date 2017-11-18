package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
