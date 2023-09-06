package photoshoot.backendworkspace.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PictainExceptionHandler {
    @ExceptionHandler(PictainException.class)
    public ResponseEntity<?> handleCustomException(PictainException e){
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
