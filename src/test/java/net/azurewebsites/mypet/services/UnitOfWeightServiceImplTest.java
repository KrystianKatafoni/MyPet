package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import net.azurewebsites.mypet.mappers.units.UowToUowDto;
import net.azurewebsites.mypet.repositories.UnitOfWeightRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UnitOfWeightServiceImplTest {

    UnitOfWeightService unitOfWeightService;

    ModelMapper modelMapper;
    UowToUowDto uowToUowDto;
    @Mock
    UnitOfWeightRepository unitOfWeightRepository;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        uowToUowDto = new UowToUowDto(modelMapper);
        unitOfWeightService = new UnitOfWeightServiceImpl(unitOfWeightRepository, uowToUowDto);
    }

    @Test
    public void testListAllUows() throws Exception {
        Long id1 = 1L;
        Long id2 = 3L;
        //given
        UnitOfWeight testUowOne = new UnitOfWeight("kilogram");
        testUowOne.setId(id1);
        UnitOfWeight testUowTwo = new UnitOfWeight("decagram");
        testUowTwo.setId(id2);
        List<UnitOfWeight> uows = new LinkedList<>();
        uows.add(testUowOne);
        uows.add(testUowTwo);
        when(unitOfWeightRepository.findAll()).thenReturn(uows);
        //when
        List<UnitOfWeightDto> uowsList = unitOfWeightService.listAllUows();

        //then
        assertEquals(2, uowsList.size());
        assertEquals(id1, uowsList.get(0).getId());
        assertEquals(id2, uowsList.get(1).getId());
        assertEquals("kilogram", uowsList.get(0).getDescription());
        assertEquals("decagram", uowsList.get(1).getDescription());
        verify(unitOfWeightRepository, times(1)).findAll();
    }
}
