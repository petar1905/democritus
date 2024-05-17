package github.petar1905.models;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.IO;
import github.petar1905.exceptions.MediaException;
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

    public Media(int id) throws SQLException, MediaException, IOException {
        String queryPath = "sql/queries/database_operations/media/select_media.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (!result.next()) {
            String format = "Media ID %d not found.";
            String msg = String.format(format, id);
            throw new MediaException(msg);
        } else {
            this.id = id;
            this.name = result.getString(1);
            this.author = result.getString(2);
            this.year = result.getInt(3);
            this.genre = result.getString(4);
            this.description = result.getString(5);
            this.quantity = result.getInt(6);
        }
    }
}