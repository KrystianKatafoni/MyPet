package net.azurewebsites.mypet.mappers.ratings;

import net.azurewebsites.mypet.domain.ratings.Vote;
import net.azurewebsites.mypet.dto.ratings.VoteDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @author Krystian Katafoni
 * @since 08.11.2017
 * Mapper class which handle mapping objects: VoteDto->Vote
 */
@Component
public class VoteDtoToVote {
    ModelMapper modelMapper;
    Vote vote;

    public VoteDtoToVote(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        vote = new Vote();
    }

    /**
     *
     * @param voteDto Data transfer object which represent vote taken from front-end
     * @return Vote object which represent vote entity in database
     */
    public Vote convert(VoteDto voteDto){
        Optional<VoteDto> vdOpt = Optional.ofNullable(voteDto);
        if (vdOpt.isPresent()){
            vote = modelMapper.map(vdOpt.get(),Vote.class);
        }
        return vote;
    }
}
