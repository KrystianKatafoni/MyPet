package net.azurewebsites.mypet.mappers.sizeproperties;

import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.sizeproperties.LengthDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LengthToLengthDtoTest {
    public static final Long LENGTH_ID = 1L;
    public static final Double LENGTH_VALUE=32.45;
    public static final Long UOL_ID = 1L;
    public static final String UOL_DESCRIPTION="meter";
    ModelMapper modelMapper;
    LengthToLengthDto converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new LengthToLengthDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Length()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfLength uol = new UnitOfLength();
        Length length = new Length();
        LengthDto lengthDto;
        uol.setId(UOL_ID);
        uol.setDescription(UOL_DESCRIPTION);
        length.setId(LENGTH_ID);
        length.setValue(LENGTH_VALUE);
        length.setUol(uol);
        //when
        lengthDto=converter.convert(length);

        //then
        assertEquals(UOL_ID, lengthDto.getUol().getId());
        assertEquals(UOL_DESCRIPTION, lengthDto.getUol().getDescription());
        assertEquals(LENGTH_ID, lengthDto.getId());
        assertEquals(LENGTH_VALUE, lengthDto.getValue(),0.0);
        assertEquals(LengthDto.class, lengthDto.getClass());
    }
}
