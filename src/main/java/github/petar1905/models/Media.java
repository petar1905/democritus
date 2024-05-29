package github.petar1905.models;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.IO;
import github.petar1905.auxillary.classes.Model;
import github.petar1905.auxillary.interfaces.Deletable;
import github.petar1905.exceptions.MediaException;
import lombok.Getter;

public class Media extends Model implements Deletable {
    private @Getter int id;
    private @Getter String name;
    private @Getter String author;
    private @Getter int year;
    private @Getter String genre;
    private @Getter String description;
    private @Getter int quantity;
    private @Getter byte[] imageByteData;

    public Media() throws SQLException, IOException, MediaException {
        deletedMsg = "This Media instance is already deleted.";
        String queryPath = "sql/queries/database_operations/media/insert_media.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        db.connection.setAutoCommit(false);
        PreparedStatement mediaStatement = db.connection.prepareStatement(query);
        mediaStatement.executeUpdate();
        PreparedStatement lastInsertId = db.connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet result = lastInsertId.executeQuery();
        if (result.next()) {
            this.id = result.getInt(1);
            db.connection.commit();
            db.connection.setAutoCommit(true);
        } else {
            db.connection.setAutoCommit(true);
            String format = "Unknown error. LAST_INSERT_ID in transaction: %d";
            String msg = String.format(format, result.getInt(1));
            throw new MediaException(msg);
        }
        String mediaDetailsQueryPath = "sql/queries/database_operations/media/insert_media_details.sql";
        String mediaDetailsQuery = IO.getInstance().readFile(mediaDetailsQueryPath);
        PreparedStatement mediaDetailsStatement = db.connection.prepareStatement(mediaDetailsQuery);
        mediaDetailsStatement.setInt(1, id);
        mediaDetailsStatement.executeUpdate();
    }

    public Media(int id) throws SQLException, MediaException, IOException {
        deletedMsg = "This Media instance is already deleted.";
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
            try {
                Blob imageBlob = result.getBlob(7);
                this.imageByteData = imageBlob.getBytes(1, (int) imageBlob.length());
            } catch(NullPointerException e) {
                this.imageByteData = null;
            }
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

    public void setName(String name) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "set_name.sql";
        this.setStringInDB(queryPath, name);
        this.name = name;
    }

    public void setAuthor(String author) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "set_author.sql";
        this.setStringInDB(queryPath, author);
        this.author = author;
    }

    public void setGenre(String genre) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "set_genre.sql";
        this.setStringInDB(queryPath, genre);
        this.genre = genre;
    }
    
    public void setDescription(String description) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "set_description.sql";
        this.setStringInDB(queryPath, description);
        this.description = description;
    }

    public void setYear(int year) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "set_year.sql";
        this.setIntInDB(queryPath, year);
        this.year = year;
    }

    public void setQuantity(int quantity) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "set_quantity.sql";
        this.setIntInDB(queryPath, quantity);
        this.quantity = quantity;
    }

    public void setImage(byte[] imageByteData) throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "sql/queries/database_operations/media/set_image.sql";
        String query = IO.getInstance().readFile(queryPath);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        Blob imageBlob = con.createBlob();
        imageBlob.setBytes(id, imageByteData);
        statement.setBlob(1, imageBlob);
        statement.setInt(2, this.getId());
        statement.executeUpdate();
    }

    public void delete() throws IOException, SQLException, MediaException {
        if (getDisabledStatus()) throw new MediaException(deletedMsg);
        String queryPath = "sql/queries/database_operations/media/delete_media.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        int result = statement.executeUpdate();
        if (result != 1) {
            String format = "Unknown error. Cannot delete ID %d";
            String msg = String.format(format, id);
            throw new MediaException(msg);
        }
        this.disable();
        this.id = 0;
        this.quantity = 0;
        this.year = 0;
        this.name = null;
        this.genre = null;
        this.description = null;
        this.author = null;
        this.imageByteData = null;
    }
}