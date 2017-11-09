package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public Set<CountryDto> listAllCountryDTO() {
        return null;
    }
}
