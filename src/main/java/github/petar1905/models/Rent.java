package github.petar1905.models;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.IO;
import github.petar1905.auxillary.classes.Model;
import github.petar1905.auxillary.interfaces.Deletable;
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;
import lombok.Getter;

public class Rent extends Model implements Deletable {
    private @Getter int id;
    private @Getter Media media;
    private @Getter User user;
    private @Getter Date startDate;
    private @Getter Date endDate;

    public Rent(int id) throws SQLException, MediaException, IOException, RentException, UserException {
        // Get rid of Rent model and replace it with methods that define a relationship between the User and Media models
        deletedMsg = "This Rent instance is already deleted.";
        String queryPath = "sql/queries/database_operations/rents/select_rent.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (!result.next()) {
            String format = "Rent ID %d not found.";
            String msg = String.format(format, id);
            throw new RentException(msg);
        } else {
            this.id = id;
            this.media = new Media(result.getInt(1));
            this.user = new User(result.getInt(2));
            this.startDate = result.getDate(3);
            this.endDate = result.getDate(4);
        }
    }

    public Rent(User user, Media media, Date startDate, Date endDate) throws SQLException, IOException, RentException {
        deletedMsg = "This Rent instance is already deleted.";
        String queryPath = "sql/queries/database_operations/rents/insert_rent.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        db.connection.setAutoCommit(false);
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, user.getId());
        statement.setInt(2, media.getId());
        statement.setDate(3, startDate);
        statement.setDate(4, endDate);
        statement.executeUpdate();
        PreparedStatement lastInsertId = db.connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet result = lastInsertId.executeQuery();
        if (result.next()) {
            db.connection.commit();
            db.connection.setAutoCommit(true);
        } else {
            db.connection.setAutoCommit(true);
            String format = "Unknown error. LAST_INSERT_ID in transaction: %d";
            String msg = String.format(format, result.getInt(1));
            throw new RentException(msg);
        }
        this.id = result.getInt(1);
        this.media = media;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void delete() throws IOException, SQLException, RentException {
        if (getDisabledStatus()) throw new RentException(deletedMsg);
        String queryPath = "sql/queries/database_operations/rents/delete_rent.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        int result = statement.executeUpdate();
        if (result != 1) {
            String format = "Unknown error. Cannot delete ID %d";
            String msg = String.format(format, id);
            throw new RentException(msg);
        }
        this.id = 0;
        this.user = null;
        this.media = null;
        this.startDate = null;
        this.endDate = null;
        this.disable();
    }
}
