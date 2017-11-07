package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CountryToCountryDto {

    private ModelMapper modelMapper;

    public CountryToCountryDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CountryDTO convert(Country country){
        CountryDTO countryDTO = modelMapper.map(country, CountryDTO.class);
        return countryDTO;
    }

}
