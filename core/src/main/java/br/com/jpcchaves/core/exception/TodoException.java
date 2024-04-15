package br.com.jpcchaves.core.exception;

public class TodoException extends RuntimeException {
    private String code;

    public TodoException(String message,
                         String code) {
        super(message);
        this.code = code;
    }
}
