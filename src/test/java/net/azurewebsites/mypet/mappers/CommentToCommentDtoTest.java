package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Author;
import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.CommentDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentToCommentDtoTest {
    public static final Long COMMENT_ID = 1L;
    public static final String COMMENT_TEXT="Lorem ipsum.]'";
    public static final Long AUTHOR_ID=1L;
    public static final String AUTHOR_NICKNAME = "Achilles";

    CommentToCommentDto converter;
    ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new CommentToCommentDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Comment()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        Comment comment = new Comment();
        Author author = new Author();
        author.setId(AUTHOR_ID);
        author.setNickname(AUTHOR_NICKNAME);
        comment.setId(COMMENT_ID);
        comment.setText(COMMENT_TEXT);
        comment.setAuthor(author);

        //when
        CommentDto commentDto = converter.convert(comment);

        //then
        assertEquals(AUTHOR_ID, commentDto.getAuthor().getId());
        assertEquals(AUTHOR_NICKNAME, commentDto.getAuthor().getNickname());
        assertEquals(COMMENT_ID, commentDto.getId());
        assertEquals(COMMENT_TEXT, commentDto.getText());


    }
}
