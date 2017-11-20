package net.azurewebsites.mypet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Krystian Katafoni
 * @since 11.11.2017
 * This exception is employ in case of not founded objects in db
 * For example: we can throw this exception when pet with id - 1 was
 * not found in database
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(){super();}
    public NotFoundException(String message){super(message);}

}
