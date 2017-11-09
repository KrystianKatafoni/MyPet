package net.azurewebsites.mypet.mappers.ratings;

import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.domain.ratings.Vote;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VoteDtoToVoteTest {
    public static final Long VOTE_ID = 1L;
    public static final Scale VOTE_RATING = Scale.COOL;
    VoteDtoToVote converter;
    ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        converter = new VoteDtoToVote(modelMapper);

    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new VoteDto()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        VoteDto voteDto = new VoteDto();
        voteDto.setId(VOTE_ID);
        voteDto.setVoteRating(VOTE_RATING);

        //when
        Vote vote = converter.convert(voteDto);

        //then
        assertEquals(VOTE_ID, vote.getId());
        assertEquals(VOTE_RATING, vote.getVoteRating());

    }
}
