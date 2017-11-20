package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 */
public interface UnitOfWeightRepository extends CrudRepository<UnitOfWeight, Long> {
}
