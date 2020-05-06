package rnd.mate00.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Spring5Handling {

    @GetMapping("/entity/{id}")
    public ResponseEntity<String> getEntity(@PathVariable("id") int id) {
        if (id > 100) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Id was too big");
        }

        return new ResponseEntity<>("Entity found, it's ok", HttpStatus.ACCEPTED);
    }
}
