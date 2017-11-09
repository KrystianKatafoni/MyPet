package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CountryToCountryDtoTest {
    public static final Long COUNTRY_ID = 2L;
    public static final String COUNTRY_NAME = "Burgundia";
    ModelMapper modelMapper;
    CountryToCountryDto converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new CountryToCountryDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Country()));
    }

    @Test
    public void testConvert() throws Exception {
        //given
        Country country = new Country();
        country.setId(COUNTRY_ID);
        country.setName(COUNTRY_NAME);
        //when

        CountryDto countryDto = converter.convert(country);

        //then
        assertEquals(COUNTRY_ID, countryDto.getId());
        assertEquals(COUNTRY_NAME, countryDto.getName());

    }
}
