package sol.in.soul.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.net.URISyntaxException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<String> alreadyRegistered() {
        return ResponseEntity.status(409).body("Url is not correct");
    }
}
