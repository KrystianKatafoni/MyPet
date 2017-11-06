package net.azurewebsites.mypet.bootstrap;

import net.azurewebsites.mypet.api.country.services.ApiCountryService;
import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryApiDTO;
import net.azurewebsites.mypet.mappers.CountryApiToCountry;
import net.azurewebsites.mypet.repositories.CountryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RunMyPet implements ApplicationListener<ContextRefreshedEvent> {
    private final String PARAM="name";
    private List<CountryApiDTO> countryList;
    private CountryRepository countryRepository;
    private ApiCountryService apiCountryService;
    private CountryApiToCountry countryApiToCountry;
    public RunMyPet(CountryRepository countryRepository, ApiCountryService apiCountryService, CountryApiToCountry countryApiToCountry) {
        this.apiCountryService = apiCountryService;
        this.countryRepository = countryRepository;
        this.countryApiToCountry = countryApiToCountry;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        saveCountriesToDB();

    }

    private void saveCountriesToDB(){

         countryList = apiCountryService.getCountries(PARAM);
         Optional<List<CountryApiDTO>> countryListOpt = Optional.of(countryList);

         if(countryListOpt.isPresent()){
             countryListOpt.get().stream().forEach(countryApiDTO ->countryRepository.save( countryApiToCountry.map(countryApiDTO)));
         }else{
             countryListOpt.orElseThrow(IllegalArgumentException::new);
         }
    }
}
