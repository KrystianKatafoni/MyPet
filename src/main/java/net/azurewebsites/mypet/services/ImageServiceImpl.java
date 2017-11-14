package net.azurewebsites.mypet.services;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final PetRepository petRepository;

    public ImageServiceImpl(PetRepository petRepository) {

        this.petRepository = petRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long petId, MultipartFile file) {

        Optional<Pet> petOpt = petRepository.findById(petId);
        if (petOpt.isPresent()) {


            try {
                int i =0;
                Byte[] byteObjects = new Byte[file.getBytes().length];
                for (byte b : file.getBytes()) {
                    byteObjects[i++]=b;
                }
                petOpt.get().setImage(byteObjects);
                petRepository.save(petOpt.get());
            } catch (IOException e) {
                log.error("Error occurred", e);
                e.printStackTrace();
            }
        }else{
            petOpt.orElseThrow(IllegalArgumentException::new);
            log.error("Pet with id" + petId + "doesn't  exist in database");
        }
    }
}