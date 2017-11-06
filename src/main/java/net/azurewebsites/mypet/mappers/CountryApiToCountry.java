package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.domain.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class CountryApiToCountry {
    ModelMapper modelMapper;

    public CountryApiToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Country map(CountryApiDTO countryApiDTO){

        Country country = modelMapper.map(countryApiDTO, Country.class);
        return country;
    }
}
