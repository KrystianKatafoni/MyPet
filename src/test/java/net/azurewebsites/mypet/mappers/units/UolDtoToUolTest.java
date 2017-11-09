package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UolDtoToUolTest {
    public static final Long UOL_ID = 1L;
    public static final String UOL_DESCRIPTION="meter";

    ModelMapper modelMapper;
    UolDtoToUol converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new UolDtoToUol(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfLengthDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfLengthDto uolDto = new UnitOfLengthDto();
        UnitOfLength uol;
        uolDto.setId(UOL_ID);
        uolDto.setDescription(UOL_DESCRIPTION);

        //when
        uol=converter.convert(uolDto);

        //then
        assertEquals(UOL_ID, uol.getId());
        assertEquals(UOL_DESCRIPTION, uol.getDescription());
        assertEquals(UnitOfLength.class, uol.getClass());
    }
}
