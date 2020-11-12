package ie.ucd.hello;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "no such stack exists")
public class NoSuchStackException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8444907592491008646L;

}
