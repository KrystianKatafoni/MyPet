package net.azurewebsites.mypet.api.country.services;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.api.country.dto.CountryApiDto;
import net.azurewebsites.mypet.mappers.countryapi.CountryApiDtoToCountry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Implementation of ApiCountryService
 * This service deserve to get countries from extern api and return list of countries
 */
@Service
public class ApiCountryServiceImpl implements ApiCountryService {
    private RestTemplate restTemplate;
    private CountryApiDtoToCountry countryApiDtoToCountry;
    private final String api_url;
    private List<Country> countries = new LinkedList<>();

    public ApiCountryServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url,
                                 CountryApiDtoToCountry countryApiDtoToCountry) {

        this.restTemplate = restTemplate;
        this.api_url = api_url;
        this.countryApiDtoToCountry = countryApiDtoToCountry;
    }

    /**
     *
     * @param param this parametr say which information has to be taken from rest api
     * @return list of all countries
     */
    @Override
    public List<Country> getCountries(String param) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("fields", param);
        CountryApiDto[] countryApiDto = restTemplate.getForObject(uriBuilder.toUriString(),CountryApiDto[].class);
        Optional<List<CountryApiDto>> countryApiDTOListOpt = Optional.ofNullable(Arrays.asList(countryApiDto));
        if(countryApiDTOListOpt.isPresent()) {
            countries = countryApiDTOListOpt.get().stream()
                    .map(countryApi -> countryApiDtoToCountry
                            .convert(countryApi))
                    .collect(Collectors.toList());
        }else{
            countryApiDTOListOpt.orElseThrow(IllegalArgumentException::new);
        }
        return countries;
    }
}
