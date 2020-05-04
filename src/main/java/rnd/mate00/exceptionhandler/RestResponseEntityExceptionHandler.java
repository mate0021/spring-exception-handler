package rnd.mate00.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler { //extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ IllegalArgumentException.class, EntityNotFoundException.class} )
    protected ResponseEntity<String> handleExceptionInternal(Exception ex, WebRequest request) {
        System.out.println("Handling in controller advice");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was an issue");
    }
}
