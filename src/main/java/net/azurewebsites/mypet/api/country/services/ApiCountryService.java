package net.azurewebsites.mypet.api.country.services;


import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryApiDTO;

import java.util.List;

public interface ApiCountryService {
    List<Country> getCountries(String param);
}
