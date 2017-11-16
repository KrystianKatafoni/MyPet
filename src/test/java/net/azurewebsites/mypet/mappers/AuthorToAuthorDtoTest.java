package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Author;
import net.azurewebsites.mypet.dto.AuthorDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorToAuthorDtoTest {
    public static final Long AUTHOR_ID=1L;
    public static final String AUTHOR_NICKNAME = "Achilles";
    AuthorToAuthorDto converter;
    ModelMapper modelMapper;
    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new AuthorToAuthorDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Author()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        Author author = new Author();
        author.setId(AUTHOR_ID);
        author.setNickname(AUTHOR_NICKNAME);

        //when
        AuthorDto authorDto = converter.convert(author);

        //then
        assertEquals(AUTHOR_ID, authorDto.getId());
        assertEquals(AUTHOR_NICKNAME, authorDto.getNickname());

    }
}
