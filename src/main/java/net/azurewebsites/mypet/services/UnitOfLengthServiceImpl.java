package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import net.azurewebsites.mypet.mappers.units.UolToUolDto;
import net.azurewebsites.mypet.repositories.UnitOfLengthRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfLengthServiceImpl implements UnitOfLengthService{
    UnitOfLengthRepository unitOfLengthRepository;
    UolToUolDto uolToUolDto;
    List<UnitOfLengthDto> uolsDto;

    public UnitOfLengthServiceImpl(UnitOfLengthRepository unitOfLengthRepository, UolToUolDto uolToUolDto) {
        this.unitOfLengthRepository = unitOfLengthRepository;
        this.uolToUolDto = uolToUolDto;
        uolsDto = new LinkedList<>();
    }

    @Override
    public List<UnitOfLengthDto> listAllUols() {
        Iterable<UnitOfLength> uols= unitOfLengthRepository.findAll();
        if(Optional.ofNullable(uols).isPresent()) {
            uolsDto = StreamSupport.stream(uols.spliterator(), false)
                    .map(uolToUolDto::convert)
                    .collect(Collectors.toList());
        }
        return uolsDto;
    }
}
