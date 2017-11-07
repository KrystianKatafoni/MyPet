package net.azurewebsites.mypet.bootstrap;

import net.azurewebsites.mypet.api.country.services.ApiCountryService;
import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.mappers.CountryApiDtoToCountry;
import net.azurewebsites.mypet.repositories.CountryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RunMyPet implements ApplicationListener<ContextRefreshedEvent> {
    private final String PARAM="name";
    private List<Country> countryList;
    private CountryRepository countryRepository;
    private ApiCountryService apiCountryService;
    private CountryApiDtoToCountry countryApiDtoToCountry;
    public RunMyPet(CountryRepository countryRepository, ApiCountryService apiCountryService, CountryApiDtoToCountry countryApiDtoToCountry) {
        this.apiCountryService = apiCountryService;
        this.countryRepository = countryRepository;
        this.countryApiDtoToCountry = countryApiDtoToCountry;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        saveCountriesToDB();

    }

    private void saveCountriesToDB(){
        countryList = apiCountryService.getCountries(PARAM);
        countryList.stream().forEach(country ->countryRepository.save(country));

    }
}
