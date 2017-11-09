package net.azurewebsites.mypet.mappers.sizeproperties;

import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.dto.sizeproperties.LengthDto;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LengthDtoToLengthTest {
    public static final Long LENGTH_ID = 1L;
    public static final Double LENGTH_VALUE=32.45;
    public static final Long UOL_ID = 1L;
    public static final String UOL_DESCRIPTION="meter";
    ModelMapper modelMapper;
    LengthDtoToLength converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new LengthDtoToLength(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new LengthDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfLengthDto uolDto = new UnitOfLengthDto();
        Length length;
        LengthDto lengthDto = new LengthDto();
        uolDto.setId(UOL_ID);
        uolDto.setDescription(UOL_DESCRIPTION);
        lengthDto.setId(LENGTH_ID);
        lengthDto.setValue(LENGTH_VALUE);
        lengthDto.setUol(uolDto);
        //when
        length=converter.convert(lengthDto);

        //then
        assertEquals(UOL_ID, length.getUol().getId());
        assertEquals(UOL_DESCRIPTION, length.getUol().getDescription());
        assertEquals(LENGTH_ID, length.getId());
        assertEquals(LENGTH_VALUE, length.getValue());
        assertEquals(Length.class, length.getClass());
    }
}
