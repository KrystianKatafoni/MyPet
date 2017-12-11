package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Author;
import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.dto.AuthorDto;
import net.azurewebsites.mypet.dto.CommentDto;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.events.PetSavedEvent;
import net.azurewebsites.mypet.events.SavedPetEventProducer;
import net.azurewebsites.mypet.mappers.CommentDtoToComment;
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
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    CommentDtoToComment commentConverter;
    public PetController(PetService petService, CountryService countryService,
                         UnitOfLengthService unitOfLengthService, UnitOfWeightService unitOfWeightService,
                         CommentDtoToComment commentConverter) {
        this.petService = petService;
        this.countryService = countryService;
        this.unitOfLengthService = unitOfLengthService;
        this.unitOfWeightService = unitOfWeightService;
        this.commentConverter = commentConverter;
    }


    @GetMapping("pet/{id}/show")
    public String showPetById(@PathVariable String id, Model model){
        AuthorDto author = new AuthorDto();
        CommentDto com = new CommentDto();
        com.setAuthor(author);
        model.addAttribute("petDto", petService.findPetDtoById(Long.valueOf(id)));
        model.addAttribute("newComment", com);
        model.addAttribute("newAuthor", new AuthorDto());
        return "pet/petshow";
    }

    @GetMapping("pet/new")
    public String newPet(Model model){

        model.addAttribute("petDto", new PetDto());
        model.addAttribute("countries", countryService.listAllCountries());
        model.addAttribute("uolList", unitOfLengthService.listAllUols());
        model.addAttribute("uowList", unitOfWeightService.listAllUows());
        model.addAttribute("rating", Scale.VERY_BAD);
        return "pet/petform";
    }
    @GetMapping("pet/browse")
    public String showPetBrowser(Model model){

       List<PetDto> list = petService.listAllDtoPets();

        model.addAttribute("petList", list);

        return "pet/browser";
    }

    @PostMapping("/pet")
    public String saveOrUpdatePet(@Valid @ModelAttribute("petDto") PetDto petDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            return "pet/petform";
        }
        PetDto savedPetDto = petService.savePetDto(petDto);
        return "redirect:/pet/"+savedPetDto.getId()+"/image";
    }

    @PostMapping("/pet/{id}/comment")
    public String updatePetWithComment(@PathVariable String id, @ModelAttribute("newComment") CommentDto newComment){
        Pet foundPet = petService.findPetById(Long.valueOf(id));
        Comment com = commentConverter.convert(newComment);
        com.setPet(foundPet);
        foundPet.getComments().add(com);
        Pet savedPet = petService.savePet(foundPet);

        return "redirect:/pet/"+savedPet.getId()+"/show";
    }

}
