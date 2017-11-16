package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.KindOfAnimal;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.domain.Temper;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.dto.AuthorDto;
import net.azurewebsites.mypet.dto.CommentDto;
import net.azurewebsites.mypet.dto.CountryDto;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.dto.ratings.RatingDto;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import net.azurewebsites.mypet.dto.sizeproperties.LengthDto;
import net.azurewebsites.mypet.dto.sizeproperties.WeightDto;
import net.azurewebsites.mypet.dto.units.UnitOfLengthDto;
import net.azurewebsites.mypet.dto.units.UnitOfWeightDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetDtoToPetTest {
    public static final Long PET_ID=1L;
    public static final Byte[] PET_BYTE = {10,20,30};
    public static final Long AUTHOR_ID = 2L;
    public static final String AUTHOR_NICKNAME = "Kutti";
    public static final Long LENGTH_ID = 1L;
    public static final Double LENGTH_VALUE=32.45;
    public static final Long UOL_ID = 1L;
    public static final String UOL_DESCRIPTION="meter";
    public static final Long WEIGHT_ID = 1L;
    public static final Double WEIGHT_VALUE=32.45;
    public static final Long UOW_ID = 1L;
    public static final String UOW_DESCRIPTION="kilogram";
    public static final Long VOTE_ID = 1L;
    public static final Scale VOTE_RATING = Scale.COOL;
    public static final Long RATING_ID = 1L;
    public static final Scale RATING_FINAL_RATING = Scale.COOL;
    public static final Long COMMENT_ID = 3L;
    public static final String COMMENT_TEXT= " Here is some comment";
    public static final Long COUNTRY_ID = 1L;
    public static final String COUNTRY_NAME = "Burgundia";
    ModelMapper modelMapper;
    PetDtoToPet converter;
    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new PetDtoToPet(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        converter.convert(null);
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new PetDto()));
    }

    @Test
    public void testConvert() throws Exception {
        //given
        UnitOfLengthDto uolDto = new UnitOfLengthDto();
        UnitOfWeightDto uowDto = new UnitOfWeightDto();
        Temper temper = Temper.AGGRESIVE;
        KindOfAnimal kindOfAnimal = KindOfAnimal.BIRD;
        AuthorDto authorDto = new AuthorDto();
        LengthDto lengthDto = new LengthDto();
        WeightDto weightDto = new WeightDto();
        Set<VoteDto> votes = new HashSet<>();
        VoteDto voteDto = new VoteDto();
        RatingDto ratingDto = new RatingDto();
        CommentDto commentDto = new CommentDto();
        Set<CommentDto> comments = new HashSet<>();
        CountryDto countryDto = new CountryDto();
        PetDto petDto = new PetDto();

        //unit of length
        uolDto.setId(UOL_ID);
        uolDto.setDescription(UOL_DESCRIPTION);
        //unit of weight
        uowDto.setId(UOW_ID);
        uowDto.setDescription(UOW_DESCRIPTION);
        //weight
        weightDto.setId(WEIGHT_ID);
        weightDto.setValue(WEIGHT_VALUE);
        weightDto.setUow(uowDto);
        //length
        lengthDto.setId(LENGTH_ID);
        lengthDto.setValue(LENGTH_VALUE);
        lengthDto.setUol(uolDto);
        //authorDto
        authorDto.setId(AUTHOR_ID);
        authorDto.setNickname(AUTHOR_NICKNAME);
        //vote
        voteDto.setId(VOTE_ID);
        voteDto.setVoteRating(VOTE_RATING);
        votes.add(voteDto);
        //rating
        ratingDto.setId(RATING_ID);
        ratingDto.setFinalRating(RATING_FINAL_RATING);
        ratingDto.setVotes(votes);
        //comment
        commentDto.setId(COMMENT_ID);
        commentDto.setAuthor(authorDto);
        commentDto.setText(COMMENT_TEXT);
        //comments
        comments.add(commentDto);
        //country
        countryDto.setName(COUNTRY_NAME);
        countryDto.setId(COUNTRY_ID);
        //pet
        petDto.setId(PET_ID);
        petDto.setImage(PET_BYTE);
        petDto.setAuthor(authorDto);
        petDto.setComments(comments);
        petDto.setCountry(countryDto);
        petDto.setKindOfAnimal(kindOfAnimal);
        petDto.setRating(ratingDto);
        petDto.setWeight(weightDto);
        petDto.setLength(lengthDto);
        petDto.setTemper(temper);

        //when
        Pet pet=converter.convert(petDto);

        //then
        assertEquals(PET_ID, pet.getId());
        assertEquals(AUTHOR_NICKNAME, pet.getAuthor().getNickname());
        assertEquals(1, pet.getComments().size());
        assertEquals(COMMENT_TEXT, pet.getComments().iterator().next().getText());
        assertEquals(COUNTRY_ID, pet.getCountry().getId());
        assertEquals(RATING_FINAL_RATING, pet.getRating().getFinalRating());
        assertEquals(WEIGHT_VALUE,pet.getWeight().getValue(),0.0);
        assertEquals(LENGTH_ID, pet.getLength().getId());
        assertEquals(UOL_DESCRIPTION, pet.getLength().getUol().getDescription());
        assertEquals(temper, pet.getTemper());
        assertEquals(kindOfAnimal, pet.getKindOfAnimal());
        assertEquals(Pet.class, pet.getClass());
    }

}
