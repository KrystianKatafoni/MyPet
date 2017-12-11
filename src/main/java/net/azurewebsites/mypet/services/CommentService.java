package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.CommentDto;
import net.azurewebsites.mypet.dto.PetDto;

import java.util.Set;

public interface CommentService {
    Set<CommentDto> listAllComments();
    PetDto addCommentForPet(PetDto petDto, CommentDto commentDto);
}
