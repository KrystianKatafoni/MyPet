package net.azurewebsites.mypet.mappers.ratings;

import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.domain.ratings.Vote;
import net.azurewebsites.mypet.dto.ratings.RatingDto;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RatingToRatingDtoTest {
    public static final Long VOTE_ID = 1L;
    public static final Scale VOTE_RATING = Scale.COOL;
    public static final Long RATING_ID = 1L;
    public static final Scale RATING_FINAL_RATING = Scale.COOL;
    ModelMapper modelMapper;
    RatingToRatingDto converter;


    @Before
    public void setUp() throws Exception {
        modelMapper = new ModelMapper();
        this.converter = new RatingToRatingDto(modelMapper);

    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Rating()));
    }

    @Test
    public void testConvert()throws Exception {

        //given
        Set<Vote> votes = new HashSet<>();
        Rating rating = new Rating();
        Vote vote = new Vote();
        vote.setId(VOTE_ID);
        vote.setVoteRating(VOTE_RATING);
        votes.add(vote);
        rating.setId(RATING_ID);
        rating.setFinalRating(RATING_FINAL_RATING);
        rating.setVotes(votes);

        //when
        RatingDto ratingDto = converter.convert(rating);

        //then
        assertEquals(RATING_FINAL_RATING, ratingDto.getFinalRating());
        assertEquals(RATING_ID, ratingDto.getId());
        assertEquals(1, ratingDto.getVotes().size());
        assertEquals(vote.getId(),ratingDto.getVotes().iterator().next().getId());
        assertEquals(vote.getVoteRating(),ratingDto.getVotes().iterator().next().getVoteRating());

    }
}
