package com.example.mockito;

public class Exs extends RuntimeException {
    public Exs() {
    }

    public Exs(String message) {
        super(message);
    }

    public Exs(String message, Throwable cause) {
        super(message, cause);
    }

    public Exs(Throwable cause) {
        super(cause);
    }

    public Exs(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
