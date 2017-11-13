package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;

import java.util.List;

public interface UnitOfWeightService {
    List<UnitOfWeightDto> listAllUows();
}
