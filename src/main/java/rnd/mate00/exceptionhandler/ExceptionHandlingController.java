package rnd.mate00.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

@Controller
public class ExceptionHandlingController {

    // some controller methods
    // ...
    //

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "")
    @ExceptionHandler(Exception.class)
    public void handlePredefinedException() {
        // just log the exception and convert it to http status code using @ResponseStatus
    }

    @ExceptionHandler({SQLException.class, SQLRecoverableException.class})
    public String onDatabaseError() {
        // here we can log exception about some database error and return error page specific for db errors
        return "databaseErrorView";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e) {
        // we can even include stacktrace in view's comment :D

        ModelAndView result = new ModelAndView();
        result.addObject("exception", e);
        result.addObject("url", request.getRequestURL());

        result.setViewName("error");

        return result;
    }
}
