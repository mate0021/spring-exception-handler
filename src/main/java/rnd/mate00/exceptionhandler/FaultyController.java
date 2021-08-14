package rnd.mate00.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaultyController {

    @GetMapping("/element/{id}")
    public ResponseEntity<String> getElement(@PathVariable("id") int id) {
        if (id > 50 && id <= 100) {
            throw new EntityNotFoundException(String.format("%s is greater than 50", id));
        }

        if (id > 100) {
            throw new IllegalArgumentException("Input value too big");
        }

        return new ResponseEntity<>("Proper element", HttpStatus.ACCEPTED);
    }

    /**
     * Active only for this controller.
     * See also {@link rnd.mate00.exceptionhandler.RestResponseEntityExceptionHandler}
     */
//    @ExceptionHandler(IllegalArgumentException.class)
    public void handle() {
        System.out.println("Handling exception in controller");
    }

}
