package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.services.PetService;
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

    public PetController(PetService petService) {
        this.petService = petService;
    }
    @GetMapping("/pet/{id}/show")
    public String showPetById(@PathVariable String id, Model model){

        return "recipe/show";
    }
    @GetMapping("pet/new")
    public String newPet(Model model){
        model.addAttribute("pet", new PetDto());
        return "pet/petform";
    }
    @PostMapping("pet")
    public String saveOrUpdatePet(@Valid @ModelAttribute("pet") PetDto petDto, BindingResult bindingResult){
        PetDto savedPetDto = petService.savePetDto(petDto);
        return "redirect:/pet/" + savedPetDto.getId() + "/show";
    }
}
