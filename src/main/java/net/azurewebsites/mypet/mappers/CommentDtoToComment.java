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
 * Mapper class which handle mapping objects: CommentDto->Comment
 */
@Slf4j
@Component
public class CommentDtoToComment {
    ModelMapper modelMapper;
    Comment comment;

    public CommentDtoToComment(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        comment = new Comment();
    }
    /**
     *
     * @param commentDto Data transfer object which represent Comment taken from front-end
     * @return Comment object which represent Comment entity in database
     */
    public Comment convert(CommentDto commentDto){
        Optional<CommentDto> commentDtoOpt = Optional.ofNullable(commentDto);
        if (commentDtoOpt.isPresent()){
            comment = modelMapper.map(commentDtoOpt.get(), Comment.class);
            log.debug("Mapping CommentDto->Comment");
        }
        return comment;
    }
}
