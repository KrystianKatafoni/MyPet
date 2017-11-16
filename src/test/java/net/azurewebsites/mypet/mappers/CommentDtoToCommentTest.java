package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.dto.AuthorDto;
import net.azurewebsites.mypet.dto.CommentDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentDtoToCommentTest {
    public static final Long COMMENT_ID = 1L;
    public static final String COMMENT_TEXT="Lorem ipsum.]'";
    public static final Long AUTHOR_ID=1L;
    public static final String AUTHOR_NICKNAME = "Achilles";

    CommentDtoToComment converter;
    ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new CommentDtoToComment(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CommentDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        CommentDto commentDto = new CommentDto();
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(AUTHOR_ID);
        authorDto.setNickname(AUTHOR_NICKNAME);
        commentDto.setId(COMMENT_ID);
        commentDto.setText(COMMENT_TEXT);
        commentDto.setAuthor(authorDto);

        //when
        Comment comment = converter.convert(commentDto);

        //then
        assertEquals(AUTHOR_ID, comment.getAuthor().getId());
        assertEquals(AUTHOR_NICKNAME, comment.getAuthor().getNickname());
        assertEquals(COMMENT_ID, comment.getId());
        assertEquals(COMMENT_TEXT, comment.getText());


    }
}
