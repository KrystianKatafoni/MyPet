package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: Country->CountryDto
 */
@Component
public class CountryToCountryDto {

    private ModelMapper modelMapper;
    private CountryDto countryDto;
    public CountryToCountryDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.countryDto = new CountryDto();
    }

    /**
     *
     * @param country object which represent country entity taken from database
     * @return Country Data transfer object which represent country passed to front-end layer
     */
    public CountryDto convert(Country country){
        Optional<Country> cOpt = Optional.ofNullable(country);
        if(cOpt.isPresent()) {
            countryDto = modelMapper.map(cOpt.get(), CountryDto.class);
        }
        return countryDto;
    }

}
