package net.azurewebsites.mypet.mappers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: CountryDto->Country
 */
@Slf4j
@Component
public class CountryDtoToCountry {
    private ModelMapper modelMapper;
    private Country country;
    public CountryDtoToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.country = new Country();
    }

    /**
     *
     * @param countryDto Data transfer object which represent country taken from front-end
     * @return Country object which represent country entity in database
     */
    public Country convert(CountryDto countryDto){
        Optional<CountryDto> cdOpt = Optional.ofNullable(countryDto);
        if(cdOpt.isPresent()) {
            country = modelMapper.map(cdOpt.get(), Country.class);
            log.debug("Mapping CountryDto->Country");
        }
        return country;
    }

}
