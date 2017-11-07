package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.domain.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryApiDtoToCountry {

    private ModelMapper modelMapper;
    private Country country;
    public CountryApiDtoToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        country = new Country();
    }

    public Country convert(CountryApiDTO countryApiDTO){
        if(Optional.ofNullable(countryApiDTO).isPresent()) {
            country = modelMapper.map(countryApiDTO, Country.class);
        }
        return country;

    }
}
