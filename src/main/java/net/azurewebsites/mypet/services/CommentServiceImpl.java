package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Comment service which implement one method to return list of all comments
 * all countries from database
 */
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
