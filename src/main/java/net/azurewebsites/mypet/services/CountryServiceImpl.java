package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDto;
import net.azurewebsites.mypet.mappers.CountryToCountryDto;
import net.azurewebsites.mypet.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Country service which implement one method to display
 * all countries from database
 */
@Service
public class CountryServiceImpl implements CountryService {
    List<CountryDto> countriesDto;
    CountryRepository countryRepository;
    CountryToCountryDto countryToCountryDto;
    public CountryServiceImpl(CountryRepository countryRepository, CountryToCountryDto countryToCountryDto) {
        this.countriesDto = new LinkedList<>();
        this.countryRepository = countryRepository;
        this.countryToCountryDto = countryToCountryDto;
    }

    @Override
    public List<CountryDto> listAllCountries() {
        Iterable<Country> countries = countryRepository.findAll();
        if (Optional.ofNullable(countries).isPresent()) {
            countriesDto = StreamSupport.stream(countries.spliterator(), false)
                    .map(countryToCountryDto::convert)
                    .collect(Collectors.toList());
        }
        return countriesDto;
    }
}