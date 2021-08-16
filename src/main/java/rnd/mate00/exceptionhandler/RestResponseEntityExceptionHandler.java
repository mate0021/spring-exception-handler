package rnd.mate00.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import rnd.mate00.exceptionhandler.exception.EntityNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler { //extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<String> handleExceptionInternal(Exception ex, WebRequest request) {
        System.out.println("Handling illegal argument in controller advice");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There was an issue with argument");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<String> handleEntityNotFound(Exception ex, WebRequest request) {
        System.out.println("Handling entity not found in controller advice");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("We didn't find your entity");
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleOthers(Exception ex, WebRequest request) {
        System.out.println("Some other case occurred.");

        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("OMG");
    }
}
