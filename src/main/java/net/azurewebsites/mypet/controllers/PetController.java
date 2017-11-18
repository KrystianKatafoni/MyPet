package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.events.PetSavedEvent;
import net.azurewebsites.mypet.events.SavedPetEventProducer;
import net.azurewebsites.mypet.services.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 * This controller is for handle saving and displaying pets
 */
@Slf4j
@Controller

public class PetController {
    PetService petService;
    CountryService countryService;
    UnitOfLengthService unitOfLengthService;
    UnitOfWeightService unitOfWeightService;
    SavedPetEventProducer producer;

    public PetController(PetService petService, CountryService countryService,
                         UnitOfLengthService unitOfLengthService, UnitOfWeightService unitOfWeightService,
                        SavedPetEventProducer producer) {
        this.petService = petService;
        this.countryService = countryService;
        this.unitOfLengthService = unitOfLengthService;
        this.unitOfWeightService = unitOfWeightService;
        this.producer = producer;

    }


    @GetMapping("/pet/{id}/show")
    public String showPetById(@PathVariable String id, Model model){

        return "pet/petshow";
    }

    @GetMapping("pet/new")
    public String newPet(Model model){
        model.addAttribute("petDto", new PetDto());
        model.addAttribute("countries", countryService.listAllCountries());
        model.addAttribute("uolList", unitOfLengthService.listAllUols());
        model.addAttribute("uowList", unitOfWeightService.listAllUows());
        model.addAttribute("def", Scale.VERY_BAD);
        return "pet/petform";
    }

    @PostMapping("/pet")
    public String saveOrUpdatePet(@Valid @ModelAttribute("petDto") PetDto petDto, BindingResult bindingResult){
        PetDto savedPetDto = petService.savePetDto(petDto);
        Optional<PetDto> savedPetDtoOpt = Optional.ofNullable(savedPetDto);
        if(savedPetDtoOpt.isPresent()){
            producer.publishSavedPetEvent(savedPetDtoOpt.get());
        }
        return "redirect:/pet/"+savedPetDto.getId()+"/image";
    }
}
