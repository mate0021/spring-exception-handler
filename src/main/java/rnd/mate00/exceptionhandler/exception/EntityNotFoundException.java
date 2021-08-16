package rnd.mate00.exceptionhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Status code is set, but response body is null
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Your entity was not found")
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
