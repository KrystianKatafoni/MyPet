package net.azurewebsites.mypet.mappers.sizeproperties;

import net.azurewebsites.mypet.domain.sizeproperties.Weight;
import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.sizeproperties.WeightDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeightToWeightDtoTest {
    public static final Long WEIGHT_ID = 1L;
    public static final Double WEIGHT_VALUE=32.45;
    public static final Long UOW_ID = 1L;
    public static final String UOW_DESCRIPTION="kilogram";
    ModelMapper modelMapper;
    WeightToWeightDto converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new WeightToWeightDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Weight()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfWeight uow = new UnitOfWeight();
        WeightDto weightDto;
        Weight weight = new Weight();
        uow.setId(UOW_ID);
        uow.setDescription(UOW_DESCRIPTION);
        weight.setId(WEIGHT_ID);
        weight.setValue(WEIGHT_VALUE);
        weight.setUow(uow);
        //when
        weightDto=converter.convert(weight);

        //then
        assertEquals(UOW_ID, weightDto.getUow().getId());
        assertEquals(UOW_DESCRIPTION, weightDto.getUow().getDescription());
        assertEquals(WEIGHT_ID, weightDto.getId());
        assertEquals(WEIGHT_VALUE, weightDto.getValue(),0.0);
        assertEquals(WeightDto.class, weightDto.getClass());
    }
}
