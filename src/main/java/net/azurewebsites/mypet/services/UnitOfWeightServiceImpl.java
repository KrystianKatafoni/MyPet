package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import net.azurewebsites.mypet.mappers.units.UowToUowDto;
import net.azurewebsites.mypet.repositories.UnitOfLengthRepository;
import net.azurewebsites.mypet.repositories.UnitOfWeightRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfWeightServiceImpl implements UnitOfWeightService{

    UnitOfWeightRepository unitOfWeightRepository;
    UowToUowDto uowToUowDto;
    List<UnitOfWeightDto> uowsDto;

    public UnitOfWeightServiceImpl(UnitOfWeightRepository unitOfWeightRepository, UowToUowDto uowToUowDto) {
        this.unitOfWeightRepository = unitOfWeightRepository;
        this.uowToUowDto = uowToUowDto;
        this.uowsDto = new LinkedList<>();
    }

    @Override
    public List<UnitOfWeightDto> listAllUows() {
        Iterable<UnitOfWeight> uows = unitOfWeightRepository.findAll();
        if(Optional.ofNullable(uows).isPresent()){
            uowsDto = StreamSupport.stream(uows.spliterator(), false)
                    .map(uowToUowDto::convert)
                    .collect(Collectors.toList());
        }
        return uowsDto;
    }
}
