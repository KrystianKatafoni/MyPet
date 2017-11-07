package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDTO;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryDtoToCountry {
    private ModelMapper modelMapper;
    private Country country;
    public CountryDtoToCountry(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.country = new Country();
    }
    public Country convert(CountryDTO countryDTO){
        if(Optional.ofNullable(countryDTO).isPresent()) {
            country = modelMapper.map(countryDTO, Country.class);
        }
        return country;
    }

}
