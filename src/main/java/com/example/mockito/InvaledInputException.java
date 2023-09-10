package com.example.mockito;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvaledInputException extends RuntimeException {
    public InvaledInputException() {
    }

    public InvaledInputException(String message) {
        super(message);
    }

    public InvaledInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvaledInputException(Throwable cause) {
        super(cause);
    }

    public InvaledInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
