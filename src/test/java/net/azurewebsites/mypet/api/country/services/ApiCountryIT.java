package net.azurewebsites.mypet.api.country.services;

import net.azurewebsites.mypet.domain.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiCountryIT {
    @Autowired
    ApiCountryService apiCountryService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetCountries() throws Exception {
        List<Country> countries = apiCountryService.getCountries("name");

        assertNotNull(countries);
        assertTrue(countries.size()>200);
        assertTrue(countries.size()<300);
        assertTrue(countries.stream().anyMatch(country->country.getName().equals("Poland")));
    }
}
