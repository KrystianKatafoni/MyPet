package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoToCountry {
    private ModelMapper modelMapper;

    public CountryDtoToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Country convert(CountryDTO countryDTO){
        Country country = modelMapper.map(countryDTO,Country.class);
        return country;
    }

}
