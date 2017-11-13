package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class PetController {
    PetService petService;
    CountryService countryService;
    UnitOfLengthService unitOfLengthService;
    UnitOfWeightService unitOfWeightService;

    public PetController(PetService petService, CountryService countryService, UnitOfLengthService unitOfLengthService, UnitOfWeightService unitOfWeightService) {
        this.petService = petService;
        this.countryService = countryService;
        this.unitOfLengthService = unitOfLengthService;
        this.unitOfWeightService = unitOfWeightService;
    }


    @GetMapping("/pet/{id}/show")
    public String showPetById(@PathVariable String id, Model model){

        return "recipe/petshow";
    }
    @GetMapping("pet/new")
    public String newPet(Model model){
        model.addAttribute("petDto", new PetDto());
        model.addAttribute("countries", countryService.listAllCountries());
        model.addAttribute("uolList", unitOfLengthService.listAllUols());
        model.addAttribute("uowList", unitOfWeightService.listAllUows());
        return "pet/petform";
    }

    @PostMapping("/pet")
    public String saveOrUpdatePet(@Valid @ModelAttribute("pet") PetDto petDto, BindingResult bindingResult){
        PetDto savedPetDto = petService.savePetDto(petDto);

        return "redirect:/index";
    }
}
