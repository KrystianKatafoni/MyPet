package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
