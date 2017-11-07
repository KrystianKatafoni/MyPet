package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.dto.CountryDTO;

import java.util.Set;

public interface CountryService {

    Set<CountryDTO> listAllCountryDTO();
}
