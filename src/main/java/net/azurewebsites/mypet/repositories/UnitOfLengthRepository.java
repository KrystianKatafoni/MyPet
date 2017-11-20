package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 */
public interface UnitOfLengthRepository extends CrudRepository<UnitOfLength,Long> {
}
