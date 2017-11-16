package net.azurewebsites.mypet.mappers.countryapi;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.api.country.dto.CountryApiDto;
import net.azurewebsites.mypet.domain.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: CountryApiDto->Country
 */
@Slf4j
@Component
public class CountryApiDtoToCountry {

    private ModelMapper modelMapper;
    private Country country;
    public CountryApiDtoToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.country = new Country();
    }

    /**
     * Converting objects from CountryApiDto to Country.
     * @param countryApiDto Data transfer object which represent country taken from api
     * @return Country object
     */
    public Country convert(CountryApiDto countryApiDto){
        Optional<CountryApiDto> cadOpt = Optional.ofNullable(countryApiDto);
        if(cadOpt.isPresent()) {
            country = modelMapper.map(cadOpt.get(), Country.class);
            log.debug("Mapping CountryApiDto->CountryApi");
        }
        return country;

    }
}
