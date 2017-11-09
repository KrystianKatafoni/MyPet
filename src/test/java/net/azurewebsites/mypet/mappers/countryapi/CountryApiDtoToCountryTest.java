package net.azurewebsites.mypet.mappers.countryapi;

import net.azurewebsites.mypet.api.country.dto.CountryApiDto;
import net.azurewebsites.mypet.domain.Country;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CountryApiDtoToCountryTest {
    public static final Long COUNTRY_ID = 2L;
    public static final String COUNTRY_NAME = "Burgundia";
    ModelMapper modelMapper;
    CountryApiDtoToCountry converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new CountryApiDtoToCountry(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CountryApiDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        CountryApiDto countryApiDto = new CountryApiDto();
        countryApiDto.setName(COUNTRY_NAME);

        //when
        Country country = converter.convert(countryApiDto);

        //then
        assertEquals(COUNTRY_NAME, country.getName());
    }
}
