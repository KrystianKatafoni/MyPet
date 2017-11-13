package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;

import java.util.List;

public interface UnitOfLengthService {
    List<UnitOfLengthDto> listAllUols();
}
