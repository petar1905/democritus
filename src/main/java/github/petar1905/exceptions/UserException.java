package github.petar1905.exceptions;
import lombok.Getter;

public class UserException extends Exception {
    private @Getter String message;
    public UserException(String message) {
        this.message = message;
    }
}
