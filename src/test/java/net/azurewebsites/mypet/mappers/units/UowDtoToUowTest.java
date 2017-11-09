package net.azurewebsites.mypet.mappers.units;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UowDtoToUowTest {
    public static final Long UOW_ID = 1L;
    public static final String UOW_DESCRIPTION ="kilogram";

    ModelMapper modelMapper;
    UowDtoToUow converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new UowDtoToUow(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfWeightDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfWeightDto uowDto = new UnitOfWeightDto();
        UnitOfWeight uow;
        uowDto.setId(UOW_ID);
        uowDto.setDescription(UOW_DESCRIPTION);

        //when
        uow=converter.convert(uowDto);

        //then
        assertEquals(UOW_ID, uow.getId());
        assertEquals(UOW_DESCRIPTION, uow.getDescription());
        assertEquals(UnitOfWeight.class, uow.getClass());
    }
}
