package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import net.azurewebsites.mypet.mappers.units.UolToUolDto;
import net.azurewebsites.mypet.repositories.UnitOfLengthRepository;
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
public class UnitOfLengthServiceImplTest {

    UnitOfLengthService unitOfLengthService;

    ModelMapper modelMapper;
    UolToUolDto uolToUolDto;
    @Mock
    UnitOfLengthRepository unitOfLengthRepository;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        uolToUolDto = new UolToUolDto(modelMapper);
        unitOfLengthService = new UnitOfLengthServiceImpl(unitOfLengthRepository, uolToUolDto);
    }

    @Test
    public void testListAllUows() throws Exception {
        Long id1 = 1L;
        Long id2 = 3L;
        //given
        UnitOfLength testUolOne = new UnitOfLength("metre");
        testUolOne.setId(id1);
        UnitOfLength testUolTwo = new UnitOfLength("foot");
        testUolTwo.setId(id2);
        List<UnitOfLength> uols = new LinkedList<>();
        uols.add(testUolOne);
        uols.add(testUolTwo);
        when(unitOfLengthRepository.findAll()).thenReturn(uols);
        //when
        List<UnitOfLengthDto> uolsList = unitOfLengthService.listAllUols();

        //then
        assertEquals(2, uolsList.size());
        assertEquals(id1, uolsList.get(0).getId());
        assertEquals(id2, uolsList.get(1).getId());
        assertEquals("metre", uolsList.get(0).getDescription());
        assertEquals("foot", uolsList.get(1).getDescription());
        verify(unitOfLengthRepository, times(1)).findAll();
    }
}
