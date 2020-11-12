package ie.ucd.hello;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "stack is empty")
public class StackEmptyException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -4387653437521711355L;

}
