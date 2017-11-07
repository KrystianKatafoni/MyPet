package net.azurewebsites.mypet.api.country.services;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.mappers.CountryApiDtoToCountry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApiCountryServiceImpl implements ApiCountryService {
    private RestTemplate restTemplate;
    private CountryApiDtoToCountry countryApiDtoToCountry;
    private final String api_url;
    private List<CountryApiDTO> countryApiDTOList;
    private List<Country> country = new LinkedList<>();

    public ApiCountryServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url, CountryApiDtoToCountry countryApiDtoToCountry) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        this.countryApiDtoToCountry = countryApiDtoToCountry;
    }

    @Override
    public List<Country> getCountries(String param) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("fields", param);
        CountryApiDTO[] countryApiDTO = restTemplate.getForObject(uriBuilder.toUriString(),CountryApiDTO[].class);
        Optional<List<CountryApiDTO>> countryApiDTOListOpt = Optional.ofNullable(Arrays.asList(countryApiDTO));
        if(countryApiDTOListOpt.isPresent()) {
            country = countryApiDTOListOpt.get().stream().map(countryApi -> countryApiDtoToCountry.convert(countryApi)).collect(Collectors.toList());
        }else{
            countryApiDTOListOpt.orElseThrow(IllegalArgumentException::new);
        }
        return country;
    }
}
