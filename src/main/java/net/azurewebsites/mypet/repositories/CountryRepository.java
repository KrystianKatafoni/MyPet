package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Country;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
}
