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
 * Mapper class which handle mapping objects: AuthorDto->Author
 */
@Slf4j
@Component
public class AuthorDtoToAuthor {
    ModelMapper modelMapper;
    Author author;

    public AuthorDtoToAuthor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        author = new Author();
    }

    /**
     *
     * @param authorDto Data transfer object which represent Author taken from front-end
     * @return Author object which represent Author entity in database
     */
    public Author convert(AuthorDto authorDto){
        Optional<AuthorDto> authorDtoOpt = Optional.ofNullable(authorDto);
        if (authorDtoOpt.isPresent()){
           author=  modelMapper.map(authorDtoOpt.get(), Author.class);
            log.debug("Mapping AuthorDto->Author");
        }
        return author;
    }
}
