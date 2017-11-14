package net.azurewebsites.mypet.mappers;

import net.azurewebsites.mypet.domain.*;
import net.azurewebsites.mypet.domain.ratings.Rating;
import net.azurewebsites.mypet.domain.ratings.Scale;
import net.azurewebsites.mypet.domain.ratings.Vote;
import net.azurewebsites.mypet.domain.sizeproperties.Length;
import net.azurewebsites.mypet.domain.sizeproperties.Weight;
import net.azurewebsites.mypet.domain.units.UnitOfLength;
import net.azurewebsites.mypet.domain.units.UnitOfWeight;
import net.azurewebsites.mypet.dto.PetDto;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.*;

import static org.junit.Assert.*;

public class PetToPetDtoTest {
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
    PetToPetDto converter;
    @Before
    public void setUp() throws Exception {
        this.modelMapper = new ModelMapper();
        this.converter = new PetToPetDto(modelMapper);
    }

    @Test
    public void testNullObject() throws Exception {
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Pet()));
    }

    @Test
    public void testConvert() throws Exception {
        //given
        UnitOfLength uol = new UnitOfLength();
        UnitOfWeight uow = new UnitOfWeight();
        Temper temper = Temper.AGGRESIVE;
        KindOfAnimal kindOfAnimal = KindOfAnimal.BIRD;
        Author author = new Author();
        Length length = new Length();
        Weight weight = new Weight();
        Set<Vote> votes = new HashSet<>();
        Vote vote = new Vote();
        Rating rating = new Rating();
        Comment comment = new Comment();
        Set<Comment> comments = new HashSet<>();
        Country country = new Country();
        Pet pet = new Pet();

        //unit of length
        uol.setId(UOL_ID);
        uol.setDescription(UOL_DESCRIPTION);
        //unit of weight
        uow.setId(UOW_ID);
        uow.setDescription(UOW_DESCRIPTION);
        //weight
        weight.setId(WEIGHT_ID);
        weight.setValue(WEIGHT_VALUE);
        weight.setUow(uow);
        //length
        length.setId(LENGTH_ID);
        length.setValue(LENGTH_VALUE);
        length.setUol(uol);
        //author
        author.setId(AUTHOR_ID);
        author.setNickname(AUTHOR_NICKNAME);
        //vote
        vote.setId(VOTE_ID);
        vote.setVoteRating(VOTE_RATING);
        votes.add(vote);
        //rating
        rating.setId(RATING_ID);
        rating.setFinalRating(RATING_FINAL_RATING);
        rating.setVotes(votes);
        //comment
        comment.setId(COMMENT_ID);
        comment.setAuthor(author);
        comment.setText(COMMENT_TEXT);
        //comments
        comments.add(comment);
        //country
        country.setName(COUNTRY_NAME);
        country.setId(COUNTRY_ID);
        //pet
        pet.setId(PET_ID);
        pet.setImage(PET_BYTE);
        pet.setAuthor(author);
        pet.setComments(comments);
        pet.setCountry(country);
        pet.setKindOfAnimal(kindOfAnimal);
        pet.setRating(rating);
        pet.setWeight(weight);
        pet.setLength(length);
        pet.setTemper(temper);

        //when
        PetDto petDto=converter.convert(pet);

        //then
        assertEquals(PET_ID, petDto.getId());
        assertEquals(AUTHOR_NICKNAME, petDto.getAuthor().getNickname());
        assertEquals(1, petDto.getComments().size());
        assertEquals(COMMENT_TEXT, petDto.getComments().iterator().next().getText());
        assertEquals(COUNTRY_ID, petDto.getCountry().getId());
        assertEquals(RATING_FINAL_RATING, petDto.getRating().getFinalRating());
        assertEquals(WEIGHT_VALUE,petDto.getWeight().getValue(),0.0);
        assertEquals(LENGTH_ID, petDto.getLength().getId());
        assertEquals(UOL_DESCRIPTION, petDto.getLength().getUol().getDescription());
        assertEquals(temper, petDto.getTemper());
        assertEquals(kindOfAnimal, petDto.getKindOfAnimal());
        assertEquals(PetDto.class, petDto.getClass());
    }
}
