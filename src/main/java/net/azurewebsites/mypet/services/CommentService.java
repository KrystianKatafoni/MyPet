package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.CommentDto;

import java.util.Set;

public interface CommentService {
    Set<CommentDto> listAllComments();
}
