package github.petar1905.models;
import lombok.Getter;

public class User {
    private @Getter int id;
    private @Getter String name;
    private @Getter String egnNumber;
    private @Getter String gsmNumber;
    private @Getter String address;
    private @Getter String description;
    // TODO: Setters that also change value in database.

    public User(int id) {
        // TODO: Query database for extra info and throw exception if not found
    }
}