package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Country;
import net.azurewebsites.mypet.dto.CountryDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CountryDtoToCountryTest {
    public static final Long COUNTRY_ID = 1L;
    public static final String COUNTRY_NAME = "Burgundia";
    ModelMapper modelMapper;
    CountryDtoToCountry converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new CountryDtoToCountry(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CountryDTO()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(COUNTRY_NAME);
        countryDTO.setId(COUNTRY_ID);

        //when
        Country country = converter.convert(countryDTO);

        //then
        assertEquals(COUNTRY_NAME, country.getName());
        assertEquals(COUNTRY_ID,country.getId());
    }
}
