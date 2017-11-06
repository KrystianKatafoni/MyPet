package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Comment;

import java.util.Set;

public interface CommentService {
    Set<Comment> listAllComments();
}
