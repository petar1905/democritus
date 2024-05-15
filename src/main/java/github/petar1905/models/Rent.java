package github.petar1905.models;

import lombok.Getter;

public class Rent {
    private @Getter Media media;
    private @Getter User user;
    // TODO: Start date and end date
    // TODO: Setters that also change value in database.

    public Rent(int userId, int mediaId) {
        // TODO: Query database for extra info and throw exception if not found
    }
}
