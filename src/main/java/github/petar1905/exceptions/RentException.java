package github.petar1905.exceptions;

import lombok.Getter;

public class RentException extends Exception {
    private @Getter String message;
    public RentException(String message) {
        this.message = message;
    }
}
