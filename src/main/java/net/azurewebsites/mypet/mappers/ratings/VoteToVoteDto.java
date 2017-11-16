package net.azurewebsites.mypet.mappers.ratings;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.ratings.Vote;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: Vote->VoteDto
 */
@Slf4j
@Component
public class VoteToVoteDto {
    ModelMapper modelMapper;
    VoteDto voteDto;

    public VoteToVoteDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        voteDto = new VoteDto();
    }

    /**
     *
     * @param vote object which represent Vote entity taken from database
     * @return Vote Data transfer object which represent vote passed to front-end layer
     */
    public VoteDto convert(Vote vote){
        Optional<Vote> vOpt = Optional.ofNullable(vote);
        if(vOpt.isPresent()){
            voteDto = modelMapper.map(vOpt.get(),VoteDto.class);
            log.debug("Mapping Vote->VoteDto");
        }
        return voteDto;
    }
}
