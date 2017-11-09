package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UolToUolDtoTest {
    public static final Long UOL_ID = 1L;
    public static final String UOL_DESCRIPTION="meter";

    ModelMapper modelMapper;
    UolToUolDto converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new UolToUolDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfLength()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfLengthDto uolDto;
        UnitOfLength uol = new UnitOfLength();
        uol.setId(UOL_ID);
        uol.setDescription(UOL_DESCRIPTION);

        //when
        uolDto=converter.convert(uol);

        //then
        assertEquals(UOL_ID, uolDto.getId());
        assertEquals(UOL_DESCRIPTION, uolDto.getDescription());
        assertEquals(UnitOfLengthDto.class, uolDto.getClass());
    }
}
