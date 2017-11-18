package net.azurewebsites.mypet.bootstrap;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.api.country.services.ApiCountryService;
import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.mappers.countryapi.CountryApiDtoToCountry;
import net.azurewebsites.mypet.repositories.CountryRepository;
import net.azurewebsites.mypet.repositories.UnitOfLengthRepository;
import net.azurewebsites.mypet.repositories.UnitOfWeightRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Run class for object initialization
 */
@Slf4j
@Component
public class RunMyPet implements ApplicationListener<ContextRefreshedEvent> {
    private final String PARAM="name";
    private List<Country> countryList;
    private CountryRepository countryRepository;
    private ApiCountryService apiCountryService;
    private CountryApiDtoToCountry countryApiDtoToCountry;
    private UnitOfLengthRepository unitOfLengthRepository;
    private UnitOfWeightRepository unitOfWeightRepository;

    public RunMyPet(CountryRepository countryRepository, ApiCountryService apiCountryService, CountryApiDtoToCountry countryApiDtoToCountry, UnitOfLengthRepository unitOfLengthRepository, UnitOfWeightRepository unitOfWeightRepository) {
        this.countryList = new LinkedList<>();
        this.countryRepository = countryRepository;
        this.apiCountryService = apiCountryService;
        this.countryApiDtoToCountry = countryApiDtoToCountry;
        this.unitOfLengthRepository = unitOfLengthRepository;
        this.unitOfWeightRepository = unitOfWeightRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //saveCountriesToDB();
       // initUnits();
    }

    /**
     * Save countries from RestApi to Database
     */
    private void saveCountriesToDB(){
        countryList = apiCountryService.getCountries(PARAM);

        countryList.stream().forEach(country ->countryRepository.save(country));
        log.debug("Country list saved from API");
    }

    /**
     * Initialization of units - weight and length
     */
    private void initUnits(){
        //units of length
        List<UnitOfLength> unitsOfLength = new LinkedList<>();
        unitsOfLength.add(new UnitOfLength("metre"));
        unitsOfLength.add(new UnitOfLength("decimetre"));
        unitsOfLength.add(new UnitOfLength("centimetre"));
        unitsOfLength.add(new UnitOfLength("inch"));
        unitsOfLength.add(new UnitOfLength("foot"));
        unitsOfLength.add(new UnitOfLength("yard"));
        unitOfLengthRepository.saveAll(unitsOfLength);
        //units of weight
        List<UnitOfWeight> unitsOfWeight = new LinkedList<>();
        unitsOfWeight.add(new UnitOfWeight("kilogram"));
        unitsOfWeight.add(new UnitOfWeight("decagram"));
        unitsOfWeight.add(new UnitOfWeight("ounce"));
        unitsOfWeight.add(new UnitOfWeight("pound"));
        unitOfWeightRepository.saveAll(unitsOfWeight);
    }
}
