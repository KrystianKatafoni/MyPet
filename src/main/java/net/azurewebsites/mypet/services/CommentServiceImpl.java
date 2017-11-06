package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.CommentDTO;
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
    public Set<Comment> listAllComments() {
        Comment comment = new Comment();
        comment.setText("jakis");
       CommentDTO commentDTO= modelMapper.map(comment,CommentDTO.class);
       System.out.println(commentDTO.getText());
        System.out.println(commentDTO.getId());
       System.out.println("TY CHUJU JEBANY");
       return null;
    }
}
