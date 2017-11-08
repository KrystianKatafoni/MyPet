package net.azurewebsites.mypet.mappers.ratings;

import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.dto.ratings.RatingDto;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RatingDtoToRatingTest {
    public static final Long VOTE_ID = 1L;
    public static final Scale VOTE_RATING = Scale.COOL;
    public static final Long RATING_ID = 1L;
    public static final Scale RATING_FINAL_RATING = Scale.COOL;
    ModelMapper modelMapper;
    RatingDtoToRating converter;


    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        this.converter = new RatingDtoToRating(modelMapper);

    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RatingDto()));
    }

    @Test
    public void testConvert()throws Exception {

        //given
        Set<VoteDto> votes = new HashSet<>();
        RatingDto ratingDto = new RatingDto();
        VoteDto voteDto = new VoteDto();
        voteDto.setId(VOTE_ID);
        voteDto.setVoteRating(VOTE_RATING);
        votes.add(voteDto);
        ratingDto.setId(RATING_ID);
        ratingDto.setFinalRating(RATING_FINAL_RATING);
        ratingDto.setVotes(votes);

        //when
        Rating rating = converter.convert(ratingDto);

        //then
        assertEquals(RATING_FINAL_RATING, rating.getFinalRating());
        assertEquals(RATING_ID, rating.getId());
        assertEquals(1, rating.getVotes().size());
        assertEquals(voteDto.getId(),rating.getVotes().iterator().next().getId());
        assertEquals(voteDto.getVoteRating(),rating.getVotes().iterator().next().getVoteRating());

    }
}
