package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryApiDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CountryApiDtoToCountryTest {
    public static final Long COUNTRY_ID = 2L;
    public static final String COUNTRY_NAME = "Burgundia";
    ModelMapper modelMapper;
    CountryApiDtoToCountry converter;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new CountryApiDtoToCountry(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CountryApiDTO()));
    }

    @Test
    public void convert() throws Exception {

        //given
        CountryApiDTO countryApiDTO = new CountryApiDTO();
        countryApiDTO.setName(COUNTRY_NAME);

        //when
        Country country = converter.convert(countryApiDTO);

        //then
        assertEquals(COUNTRY_NAME, country.getName());
    }
}
