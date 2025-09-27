package teamkim.barrier_free_kiosk_spring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        ExceptionCode exceptionCode = e.getExceptionCode();
        return new ResponseEntity<>(exceptionCode.getMessage(), exceptionCode.getCode());
    }
}