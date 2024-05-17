package github.petar1905.exceptions;

import lombok.Getter;

public class MediaException extends Exception {
    private @Getter String message;
    public MediaException(String message) {
        this.message = message;
    }
}
