package net.azurewebsites.mypet.controllers;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.AuthorDto;
import net.azurewebsites.mypet.dto.CommentDto;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.services.CommentService;
import net.azurewebsites.mypet.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CommentController {
    PetService petService;
    CommentService commentService;

    public CommentController(PetService petService, CommentService commentService) {
        this.petService = petService;
        this.commentService = commentService;
    }

}
