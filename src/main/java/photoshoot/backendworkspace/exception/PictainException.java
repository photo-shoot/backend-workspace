package photoshoot.backendworkspace.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PictainException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public PictainException(String message, HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
