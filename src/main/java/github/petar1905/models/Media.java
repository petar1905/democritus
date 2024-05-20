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

    public Media() throws SQLException, IOException, MediaException {
        String queryPath = "sql/queries/database_operations/media/insert_media.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            this.id = result.getInt(1);
        } else {
            String format = "Unknown error. LAST_INSERT_ID in transaction: %d";
            String msg = String.format(format, result.getInt(1));
            throw new MediaException(msg);
        }
    }

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

    private void setStringInDB(String queryPath, String newValue) throws SQLException, IOException {
        String baseDirectory = "sql/queries/database_operations/media";
        queryPath = String.format("%s/%s", baseDirectory, queryPath);
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    private void setIntInDB(String queryPath, int newValue) throws SQLException, IOException {
        String baseDirectory = "sql/queries/database_operations/media";
        queryPath = String.format("%s/%s", baseDirectory, queryPath);
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    public void setName(String name) throws IOException, SQLException {
        String queryPath = "set_name.sql";
        this.setStringInDB(queryPath, name);
        this.name = name;
    }

    public void setAuthor(String author) throws IOException, SQLException {
        String queryPath = "set_author.sql";
        this.setStringInDB(queryPath, author);
        this.author = author;
    }

    public void setGenre(String genre) throws IOException, SQLException {
        String queryPath = "set_genre.sql";
        this.setStringInDB(queryPath, author);
        this.genre = genre;
    }
    
    public void setDescription(String description) throws IOException, SQLException {
        String queryPath = "set_description.sql";
        this.setStringInDB(queryPath, description);
        this.description = description;
    }

    public void setYear(int year) throws IOException, SQLException {
        String queryPath = "set_year.sql";
        this.setIntInDB(queryPath, year);
        this.year = year;
    }
}