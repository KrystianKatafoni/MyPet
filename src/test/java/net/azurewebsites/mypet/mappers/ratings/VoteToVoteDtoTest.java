package net.azurewebsites.mypet.mappers.ratings;

import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.domain.ratings.Vote;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VoteToVoteDtoTest {
    public static final Long VOTE_ID = 1L;
    public static final Scale VOTE_RATING = Scale.COOL;
    VoteToVoteDto converter;
    ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new VoteToVoteDto(modelMapper);

    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Vote()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        Vote vote = new Vote();
        vote.setId(VOTE_ID);
        vote.setVoteRating(VOTE_RATING);

        //when
        VoteDto voteDto = converter.convert(vote);

        //then
        assertEquals(VOTE_ID, voteDto.getId());
        assertEquals(VOTE_RATING, voteDto.getVoteRating());

    }

}
