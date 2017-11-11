package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.CountryDto;

import java.util.Set;

public interface CountryService {

    Set<CountryDto> listAllCountries();
}
