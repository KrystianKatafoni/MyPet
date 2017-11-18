package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDto;
import net.azurewebsites.mypet.mappers.CountryToCountryDto;
import net.azurewebsites.mypet.repositories.CountryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

    CountryService countryService;
    ModelMapper modelMapper = new ModelMapper();
    CountryToCountryDto countryToCountryDto = new CountryToCountryDto(modelMapper);
    @Mock
    CountryRepository countryRepository;

    @Before
    public void setUp() throws Exception {
        countryService = new CountryServiceImpl(countryRepository, countryToCountryDto);
    }

    @Test
    public void testListAllCountries() throws Exception {

        //given
        List<Country> countries = new LinkedList<>();
        //country one
        Country countryTestOne = new Country();
        countryTestOne.setId(1L);
        //country two
        Country countryTestTwo = new Country();
        countryTestTwo.setId(3L);

        countries.add(countryTestOne);
        countries.add(countryTestTwo);

        when(countryRepository.findAll()).thenReturn(countries);
        //when
        List<CountryDto> countryList = countryService.listAllCountries();
        //then
        verify(countryRepository, times(1)).findAll();
        assertEquals(2, countryList.size());
    }
}
