package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.CommentDto;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.services.ImageService;
import net.azurewebsites.mypet.services.PetService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 * This controller handle adding image to pet and displaying image
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

    @GetMapping("pet/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){

        model.addAttribute("petDto", petService.findPetDtoById(Long.valueOf(id)));
        log.debug("PetDto added to model attribute in showUploadForm");
        return "pet/imageform";
    }
    @PostMapping("pet/{id}/image")
    public String saveImage(@PathVariable String id, @RequestParam("imagefile") MultipartFile file, Model model){

        imageService.saveImageFile(Long.valueOf(id), file);
        log.debug("Image saved in saveImage");
        return "redirect:/pet/"+id+"/show";
    }
    @GetMapping("pet/{id}/petimage")
    public void renderImage(@PathVariable String id, HttpServletResponse response) throws IOException{
        PetDto petDto = petService.findPetDtoById(Long.valueOf(id));

        if (petDto.getImage() != null) {
            byte[] byteArray = new byte[petDto.getImage().length];
            int i = 0;

            for (Byte wrappedByte : petDto.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
