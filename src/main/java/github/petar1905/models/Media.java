package github.petar1905.models;
import lombok.Getter;

public class Media {
    private @Getter int id;
    private @Getter String name;
    private @Getter String author;
    private @Getter int year;
    private @Getter String genre;
    private @Getter String description;
    private @Getter int quantity;
    // TODO: Image field
    // TODO: Setters that also change value in database.

    public Media(int id) {
        // TODO: Query database for extra info and throw exception if not found
    }
}