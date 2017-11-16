package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Author;
import net.azurewebsites.mypet.dto.AuthorDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorDtoToAuthorTest {
    public static final Long AUTHOR_ID=1L;
    public static final String AUTHOR_NICKNAME = "Achilles";
    AuthorDtoToAuthor converter;
    ModelMapper modelMapper;
    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new AuthorDtoToAuthor(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new AuthorDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(AUTHOR_ID);
        authorDto.setNickname(AUTHOR_NICKNAME);

        //when
        Author author = converter.convert(authorDto);

        //then
        assertEquals(AUTHOR_ID, author.getId());
        assertEquals(AUTHOR_NICKNAME, author.getNickname());

    }
}
