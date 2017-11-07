package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.dto.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public Set<CountryDTO> listAllCountryDTO() {
        return null;
    }
}
