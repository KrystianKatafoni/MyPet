package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.domain.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class CountryApiDtoToCountry {

    private ModelMapper modelMapper;

    public CountryApiDtoToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Country convert(CountryApiDTO countryApiDTO){

        Country country = modelMapper.map(countryApiDTO, Country.class);
        return country;

    }
}
