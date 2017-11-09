package net.azurewebsites.mypet.mappers.sizeproperties;

import net.azurewebsites.mypet.domain.sizeproperties.Weight;
import net.azurewebsites.mypet.dto.sizeproperties.WeightDto;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeightDtoToWeightTest {
    public static final Long WEIGHT_ID = 1L;
    public static final Double WEIGHT_VALUE=32.45;
    public static final Long UOW_ID = 1L;
    public static final String UOW_DESCRIPTION="kilogram";
    ModelMapper modelMapper;
    WeightDtoToWeight converter;

    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new WeightDtoToWeight(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new WeightDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        UnitOfWeightDto uowDto = new UnitOfWeightDto();
        Weight weight;
        WeightDto weightDto = new WeightDto();
        uowDto.setId(UOW_ID);
        uowDto.setDescription(UOW_DESCRIPTION);
        weightDto.setId(WEIGHT_ID);
        weightDto.setValue(WEIGHT_VALUE);
        weightDto.setUow(uowDto);
        //when
        weight=converter.convert(weightDto);

        //then
        assertEquals(UOW_ID, weight.getUow().getId());
        assertEquals(UOW_DESCRIPTION, weight.getUow().getDescription());
        assertEquals(WEIGHT_ID, weight.getId());
        assertEquals(WEIGHT_VALUE, weight.getValue());
        assertEquals(Weight.class, weight.getClass());
    }
}
