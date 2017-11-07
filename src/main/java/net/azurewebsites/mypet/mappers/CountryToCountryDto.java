package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryToCountryDto {

    private ModelMapper modelMapper;
    private CountryDTO countryDTO;
    public CountryToCountryDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.countryDTO = new CountryDTO();
    }

    public CountryDTO convert(Country country){
        if(Optional.ofNullable(country).isPresent()) {
            countryDTO = modelMapper.map(country, CountryDTO.class);
        }
        return countryDTO;
    }

}
