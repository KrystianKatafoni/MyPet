package net.azurewebsites.mypet.mappers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 * Mapper class which handle mapping objects: Comment->CommentDto
 */
@Slf4j
@Component
public class CommentToCommentDto {
    ModelMapper modelMapper;
    CommentDto commentDto;

    public CommentToCommentDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        commentDto = new CommentDto();
    }
    /**
     *
     * @param comment Comment object which represent Comment entity taken from database
     * @return Comment Data transfer object which represent Comment passed to front-end layer
     */
    public CommentDto convert(Comment comment){
        Optional<Comment> commentOpt = Optional.ofNullable(comment);
        if (commentOpt.isPresent()){
            commentDto = modelMapper.map(commentOpt.get(), CommentDto.class);
            log.debug("Mapping Comment->CommentDto");
        }
        return commentDto;
    }
}
