package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UowToUowDtoTest {
    public static final Long UOW_ID = 1L;
    public static final String UOW_DESCRIPTION ="kilogram";

    ModelMapper modelMapper;
    UowToUowDto converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new UowToUowDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfWeight()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfWeightDto uowDto;
        UnitOfWeight uow = new UnitOfWeight();
        uow.setId(UOW_ID);
        uow.setDescription(UOW_DESCRIPTION);

        //when
        uowDto=converter.convert(uow);

        //then
        assertEquals(UOW_ID, uowDto.getId());
        assertEquals(UOW_DESCRIPTION, uowDto.getDescription());
        assertEquals(UnitOfWeightDto.class, uowDto.getClass());
    }
}
