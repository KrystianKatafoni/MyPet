package net.azurewebsites.mypet.api.country.services;

import net.azurewebsites.mypet.dto.CountryApiDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiCountryServiceImpl implements ApiCountryService {
    private RestTemplate restTemplate;
    private final String api_url;

    public ApiCountryServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<CountryApiDTO> getCountries(String param) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("fields", param);
        CountryApiDTO[] countryApiDTO = restTemplate.getForObject(uriBuilder.toUriString(),CountryApiDTO[].class);

        return Arrays.asList(countryApiDTO);
    }
}
