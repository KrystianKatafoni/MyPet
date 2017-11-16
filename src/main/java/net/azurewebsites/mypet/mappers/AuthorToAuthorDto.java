package net.azurewebsites.mypet.mappers;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Author;
import net.azurewebsites.mypet.dto.AuthorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 * Mapper class which handle mapping objects: Author -> AuthorDto
 */
@Slf4j
@Component
public class AuthorToAuthorDto {
    ModelMapper modelMapper;
    AuthorDto authorDto;

    public AuthorToAuthorDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        authorDto = new AuthorDto();
    }

    /**
     *
     * @param author Author object which represent Author entity taken from database
     * @return Author Data transfer object which represent Author passed to front-end layer
     */
    public AuthorDto convert(Author author){
        Optional<Author> authorOpt = Optional.ofNullable(author);
        if (authorOpt.isPresent()){
            authorDto =  modelMapper.map(authorOpt.get(), AuthorDto.class);
            log.debug("Mapping Author -> AuthorDto");
        }
        return authorDto;
    }
}
