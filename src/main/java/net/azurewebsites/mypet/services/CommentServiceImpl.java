package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CommentServiceImpl implements CommentService {
    private final ModelMapper modelMapper;

    public CommentServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<CommentDto> listAllComments() {
       return null;
    }
}
