package net.azurewebsites.mypet.services;

import net.azurewebsites.mypet.domain.Comment;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.dto.CommentDto;
import net.azurewebsites.mypet.dto.PetDto;
import net.azurewebsites.mypet.mappers.CommentDtoToComment;
import net.azurewebsites.mypet.mappers.PetDtoToPet;
import net.azurewebsites.mypet.mappers.PetToPetDto;
import net.azurewebsites.mypet.repositories.CommentRepository;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Comment service which implement one method to return list of all comments
 * all countries from database
 */
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {
    private final ModelMapper modelMapper;
    private CommentRepository commentRepository;
    private CommentDtoToComment commentDtoToComment;
    private PetDtoToPet petDtoToPet;
    private PetToPetDto petToPetDto;
    private PetService petService;
    private PetRepository petRepository;

    public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository,
                              CommentDtoToComment commentDtoToComment, PetDtoToPet petDtoToPet, PetToPetDto petToPetDto,
                              PetService petService, PetRepository petRepository) {
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.commentDtoToComment = commentDtoToComment;
        this.petDtoToPet = petDtoToPet;
        this.petToPetDto = petToPetDto;
        this.petService = petService;
        this.petRepository = petRepository;
    }

    @Override
    public Set<CommentDto> listAllComments() {
        return null;
    }

    @Override
    public PetDto addCommentForPet(PetDto petDto, CommentDto commentDto) {
        Pet pet = petDtoToPet.convert(petDto);
        Comment comment = commentDtoToComment.convert(commentDto);
        Comment savedComment = commentRepository.save(comment);
        pet.getComments().add(savedComment);
        Pet savedPet = petRepository.save(pet);
        return petToPetDto.convert(savedPet);
    }
}
