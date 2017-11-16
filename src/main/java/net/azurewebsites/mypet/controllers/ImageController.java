package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.services.ImageService;
import net.azurewebsites.mypet.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 *
 */
@Slf4j
@Controller
public class ImageController {
    ImageService imageService;
    PetService petService;

    public ImageController(ImageService imageService, PetService petService) {
        this.imageService = imageService;
        this.petService = petService;
    }

    @GetMapping("/pet/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("petDto", petService.findPetById(Long.valueOf(id)));

        return "pet/imageform";
    }
    @PostMapping("pet/{id}/image")
    public String saveImage(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id), file);
        return "redirect:/index";
    }
}
