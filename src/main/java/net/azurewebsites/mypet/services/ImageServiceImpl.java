package net.azurewebsites.mypet.services;

import lombok.extern.slf4j.Slf4j;
import net.azurewebsites.mypet.domain.Pet;
import net.azurewebsites.mypet.repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final PetRepository petRepository;

    public ImageServiceImpl( PetRepository petRepository) {

        this.petRepository = petRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long petId, MultipartFile file) {

        try {
           Pet pet = petRepository.findById(petId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            pet.setImage(byteObjects);

            petRepository.save(pet);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}